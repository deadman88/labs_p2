package com.brainacad.serialize;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        User[] users = new User[5];

        users[0] = new User("Vasyl", "Petrnko", 34);
        users[1] = new User("Petro", "Nazarenko", 24);
        users[2] = new User("Anton", "kovalenko", 40);
        users[3] = new User("Ivan", "Ivanenko", 23);
        users[4] = new User("Stepan", "Stepanenko", 56);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            for (User u : users) {
                oos.writeObject(u);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        User[] usersDeserialize = new User[users.length];
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))) {
            User user = null;
            int i = 0;
            try {
                while ((user = (User) ois.readObject()) != null) {
                    usersDeserialize[i++] = user;
                }
            } catch (EOFException e) {
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("User Deserialize");
        for (User u : usersDeserialize) {
            System.out.println(u);
        }

    }
}
