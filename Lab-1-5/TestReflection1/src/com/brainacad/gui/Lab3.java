package com.brainacad.gui;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Павло on 10.08.2017.
 */
public class Lab3 {
    public static void main(String[] args) {

        Class myClass = null;

        try {
            myClass = Class.forName("com.brainacad.gui.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        MyClass myClassIns = null;

        try {
            Constructor con = myClass.getDeclaredConstructor(String.class, int.class);
            myClassIns = (MyClass)con.newInstance("Good", 9);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            Method m1 = myClass.getDeclaredMethod("setC", double.class);
                m1.invoke(myClassIns, 33.5);
            Method m2 = myClass.getDeclaredMethod("setD", boolean.class);
                m2.invoke(myClassIns, true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("Class name: " + myClass.getCanonicalName());
        System.out.println("All fields:");

        Field[] fields = myClass.getDeclaredFields();

        for (Field f : fields) {
            f.setAccessible(true);
            System.out.println("Name: " + f.getName());
            System.out.println("\tType: " + f.getType());
            try {
                System.out.println("\tValue: " + f.get(myClassIns));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println();
        }


    }
}
