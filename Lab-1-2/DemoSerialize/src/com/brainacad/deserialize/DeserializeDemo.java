package com.brainacad.deserialize;

import com.brainacad.oop.lab1.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by Павло on 06.07.2017.
 */
public class DeserializeDemo {
    public static void main(String[] args) {
        Employee employeeDes = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"))) {
            employeeDes = (Employee)ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(employeeDes);
    }
}
