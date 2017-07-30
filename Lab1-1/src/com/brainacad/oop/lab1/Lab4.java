package com.brainacad.oop.lab1;

import java.io.*;

/**
 * Created by Павло on 04.07.2017.
 */
public class Lab4 {
    public static void main(String[] args) {
        String pathIn = "E:\\java\\work\\LabPart2\\Lab1-1\\src\\com\\brainacad\\oop\\lab1\\StartFileForLab4.java";
        File file = new File(pathIn);
        StringBuilder sb = new StringBuilder();
        try(FileReader fileReader = new FileReader(file)) {
            int b = 0;
            while ((b = fileReader.read()) != -1) {
                if((char)b == 'p'){
                    StringBuilder str = new StringBuilder("p");
                    char c = 0;
                    if ((c = (char)fileReader.read()) == 'u') {
                        str.append('u');
                        if ((c = (char)fileReader.read()) == 'b') {
                            str.append('b');
                            if ((c = (char)fileReader.read()) == 'l') {
                                str.append('l');
                                if ((c = (char)fileReader.read()) == 'i') {
                                    str.append('i');
                                    if ((c = (char)fileReader.read()) == 'c') {
                                        sb.append("private");
                                    } else {
                                        sb.append(str);
                                        sb.append(c);
                                    }
                                } else {
                                    sb.append(str);
                                    sb.append(c);
                                }
                            } else {
                                sb.append(str);
                                sb.append(c);
                            }
                        } else {
                            sb.append(str);
                            sb.append(c);
                        }
                    } else {
                        sb.append(str);
                        sb.append(c);
                    }
                } else {
                    //System.out.print((char)b);
                    sb.append((char) b);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
    }
}
