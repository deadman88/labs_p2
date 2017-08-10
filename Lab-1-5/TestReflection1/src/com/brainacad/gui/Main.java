package com.brainacad.gui;

import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) {
	    MyClass c = new MyClass();

	    Class cl = c.getClass();

        System.out.println("ClassName: " + cl.getName());

        System.out.println("Modifiers: " + Modifier.toString(cl.getModifiers()));
        System.out.println();

        Field[] fields = cl.getFields();

        System.out.println("Public fields");
        for (Field f : fields) {
            System.out.println("Name: " + f.getName() + ", Type: " + f.getType());
        }

        Field[] allfields = cl.getDeclaredFields();

        System.out.println();
        System.out.println("All fields");
        for (Field f : allfields) {
            System.out.println("Name: " + f.getName() + ", Type: " + f.getType() + ", Modifiers: " + Modifier.toString(f.getModifiers()));
        }

        Constructor[] constructors = cl.getDeclaredConstructors();

        int i = 0;
        for (Constructor con : constructors) {
            System.out.println();
            System.out.println("Constructor " + i++ + ": count parameters: " + con.getParameterCount());

            Parameter[] parameters = con.getParameters();

            System.out.println("Types parameters");
            for (Parameter p : parameters) {
                System.out.println(p.getType());
            }
        }

        Method[] methods = cl.getDeclaredMethods();
        System.out.println("\nMethods:");
        for (Method m : methods) {
            System.out.println("Name: " + m.getName());
            System.out.println("\tReturn type: " + m.getReturnType());

            Parameter[] parameters = m.getParameters();
            System.out.print("Parameters type: ");
            for (Parameter p : parameters) {
                System.out.print(p.getType() + ", ");
            }
            System.out.println();
            System.out.println();
        }


    }
}
