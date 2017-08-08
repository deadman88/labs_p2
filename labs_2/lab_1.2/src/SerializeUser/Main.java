package SerializeUser;

import java.io.*;

/**
 * Created by stas on 07.08.2017.
 */
public class Main {
    public static void main(String[] args) {
        User user = new User("one","two",25);
        User user1 = new User("three","four",52);
        try {
            RandomAccessFile raf = new RandomAccessFile("users.ser","rw");
            writeU(user,raf);
            writeU(user1,raf);
        } catch (IOException e) {
            e.printStackTrace();
        }

        User user2 = null;
        User user3 = null;

        try {
            RandomAccessFile raf = new RandomAccessFile("users.ser","rw");
             user2 = readU(raf);
             user3 = readU(raf);
            System.out.println(user2.toString());
            System.out.println(user3.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeU (User user, RandomAccessFile raf){
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
    public static User readU (RandomAccessFile raf){
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
