package com.xtream;

import com.brainacad.oop.lab1.Employee;
import com.thoughtworks.xstream.XStream;

import java.io.*;

/**
 * Created by Павло on 06.07.2017.
 */
public class XSTreamDes {
    public static void main(String[] args) {
        Class<?>[] classes = new Class[] { Employee.class };
        XStream xStream = new XStream();
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(classes);
        Employee e = null;
        Employee e2 = null;
        Employee e3 = null;

        try(FileReader fis = new FileReader("employee.txt")) {
            e = (Employee)xStream.fromXML(fis);
            e2 = (Employee)xStream.fromXML(fis);
            e3 = (Employee)xStream.fromXML(fis);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        System.out.println(e);
        System.out.println(e2);
        System.out.println(e3);
    }
}
