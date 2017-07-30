package com.brainacad.oop.lab1;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("users.txt", "rw");
            AccountingUser accountingUser = new AccountingUser(randomAccessFile);
           // accountingUser.getByts();
            accountingUser.testUsers();
            accountingUser.printFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
