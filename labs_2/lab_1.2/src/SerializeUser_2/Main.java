package SerializeUser_2;

import java.io.*;

/**
 * Created by stas on 08.08.2017.
 */
public class Main {

    public static void main(String[] args) {

        User[] users = new User[3];
        users[0] = new User("one", "onetwo", 25);
        users[1] = new User("two", "twothree", 27);
        users[2] = new User("three", "threefour", 29);
        
        try {
            RandomAccessFile raf = new RandomAccessFile("users.ser", "rw");
            for (int i = 0; i < users.length; i++) {
                writeU(users[i], raf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        User[] users2 = new User[users.length];

        try {
            RandomAccessFile raf = new RandomAccessFile("users.ser", "rw");
            for (int i = 0; i < users2.length; i++) {
                users2[i] = readU(raf);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < users2.length; i++) {
            System.out.println(users2[i].toString());
        }


    }

    public static void writeU(User user, RandomAccessFile raf) {
        try {
            raf.writeBytes(user.getFirstName());
            raf.writeBytes("\n");
            raf.writeBytes(user.getSecondName());
            raf.writeBytes("\n");
            raf.writeBytes(String.valueOf(user.getAge()));
            raf.writeBytes("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User readU(RandomAccessFile raf) {
        User user = new User();
        try {
            user.setFirstName(raf.readLine());
            user.setSecondName(raf.readLine());
            user.setAge(Integer.parseInt(raf.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

}
