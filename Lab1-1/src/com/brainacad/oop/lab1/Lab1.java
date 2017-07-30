package com.brainacad.oop.lab1;

import java.io.File;

public class Lab1 {

    public static void main(String[] args) {
        String path;
        if (args.length == 0) {
            path = ".";
        } else {
            path = args[0];
        }
        File file = new File(path);
        if (file.exists()) {
            String[] fileNames = file.list();
            for (String fN : fileNames) {
                System.out.println(fN);
            }
        } else {
            System.out.println("Вказаний файл не існує");
        }
    }
}
