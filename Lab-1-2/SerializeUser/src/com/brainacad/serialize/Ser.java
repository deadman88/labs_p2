package com.brainacad.serialize;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Павло on 06.07.2017.
 */
public class Ser {
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User("Pavlo", "Kurpela", 24);
        User user3 = new User();
        user3.setAge(25);
        user3.setFirstName("Orest");
        user3.setLastName("Bachinskyj");
        try(RandomAccessFile randomAccessFile = new RandomAccessFile("user2.ser", "rw")) {
            writeUser(user1, randomAccessFile);
            writeUser(user2, randomAccessFile);
            writeUser(user3, randomAccessFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }

    }
    static void writeUser(User us, RandomAccessFile raf) {
        try {
            if (us.getFirstName() != null) {
                raf.writeBytes(us.getFirstName());
                System.out.println(us.getFirstName());
            } else raf.writeBytes("");
            raf.writeChar('\n');
            //raf.writeChar(10);
            if (us.getLastName() != null) {
                raf.writeBytes(us.getLastName());
                System.out.println(us.getLastName());
            } else raf.writeBytes("");
            raf.writeChar('\n');
            //raf.writeChar(10);
            raf.writeInt(us.getAge());
            System.out.println(us.getAge());
          //  raf.writeChar(13);
//            raf.writeChar(10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
