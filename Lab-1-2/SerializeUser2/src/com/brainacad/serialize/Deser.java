package com.brainacad.serialize;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Павло on 06.07.2017.
 */
public class Deser {
    public static void main(String[] args) {

        User userDes1 = null;
        User userDes2 = null;
        User userDes3 = null;

        try(RandomAccessFile randomAccessFile = new RandomAccessFile("user2.ser", "rw")) {
           userDes1 = readUser(randomAccessFile);
           userDes2 = readUser(randomAccessFile);
           userDes3 = readUser(randomAccessFile);
//            String s = null;
//            while ((s = randomAccessFile.readLine()) != null) {
//                System.out.println(s);
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }

        System.out.println(userDes1);
        System.out.println(userDes2);
        System.out.println(userDes3);
    }
    static User readUser(RandomAccessFile raf) {
        User user = new User();
        try {
            String a = raf.readLine();

            if (a.getBytes().length > 1) {
                user.setFirstName(a);
            }
            a = raf.readLine();
            if (a.getBytes().length > 1) {
                user.setLastName(a);
            }
            user.setAge(raf.readInt());
            //System.out.println(raf.readInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
