package com.brainacad.oop.lab1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Created by Павло on 04.07.2017.
 */
public class AccountingUser {
    RandomAccessFile raf;

    public AccountingUser(RandomAccessFile raf) {
        this.raf = raf;
    }


    public void printFile() {
      try {
            String b = null;
            raf.seek(0);
            while ((b = raf.readLine()) != null) {
                System.out.println(b);
            }
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public void testUsers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть імя користувача:");
        String usersName = scanner.nextLine();
        boolean isUser = false;
        try {
            String b = null;
            while ((b = raf.readLine()) != null) {
                String[] strings = b.split(":");
                if (strings[0].equals(usersName)) {
                   raf.seek(raf.getFilePointer()-3);
                   //int n = raf.read();
                    Integer n = new Integer(strings[1]);
                    n++;
                    raf.write(n.toString().getBytes());
                    isUser = true;
                }
            }
            if(!isUser) {
                StringBuilder newUser  = new StringBuilder();
                newUser.append(usersName);
                newUser.append(":1");
                newUser.append((char)13);
                newUser.append((char)10);
                //String newUser = usersName + ":1\n";
                raf.write(newUser.toString().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getByts() {
        try {
            byte[] b = Files.readAllBytes(new File("users.txt").toPath());
            for( byte by : b) {
                System.out.println(by);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        @Override
    protected void finalize() throws Throwable {
        raf.close();
    }
}
