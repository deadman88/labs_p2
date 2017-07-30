package com.xtream;

import com.brainacad.oop.lab1.Employee;
import com.thoughtworks.xstream.XStream;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Павло on 06.07.2017.
 */
public class XTreamSer {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Pavlo");
        employee.setAddress("Budnogo");
        employee.setSSN(31231232);
        employee.setNumber(5);

        Employee employee1 = new Employee();
        employee1.setName("Mykola");
        employee1.setAddress("Ruska");
        employee1.setSSN(2323232);
        employee1.setNumber(5);

        Employee employee2 = new Employee();
        employee2.setName("Orest");
        employee2.setAddress("Karpenka");
        employee2.setSSN(234234);
        employee2.setNumber(7);


            XStream xStream = new XStream();

            try(FileWriter fs = new FileWriter("employee.txt")) {
            xStream.toXML(employee, fs);
            //fs.write('\n');
            xStream.toXML(employee1, fs);
            //fs.write('\n');
            xStream.toXML(employee2, fs);
        } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        System.out.println(employee);
    }
}
