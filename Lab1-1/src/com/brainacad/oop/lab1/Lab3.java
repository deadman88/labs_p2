package com.brainacad.oop.lab1;

import java.io.*;

/**
 * Created by Павло on 04.07.2017.
 */
public class Lab3 {
    public static void main(String[] args) {
        String pathIn = args[0];
        String pathOut = args[1];
        File fileIn = new File(pathIn);
        File fileOut = new File(pathOut);
        try(FileInputStream fileInputStream = new FileInputStream(fileIn);
            FileOutputStream fileOutputStream = new FileOutputStream(fileOut)) {

            int b = 0;
            while ((b = fileInputStream.read()) != -1) {
                fileOutputStream.write(b);
            }
            System.out.println("Копіювання завершено!!!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
