package com.brainacad.oop.lab1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Павло on 06.07.2017.
 */
public class SerializeDemo {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Pavlo");
        employee.setAddress("Budnogo");
        employee.setSSN(42344234);
        employee.setNumber(7);

        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
            obj.writeObject(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
