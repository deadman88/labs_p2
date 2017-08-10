package com.brainacad.gui;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {
	    String myStr = "abcd";

	    Class classString = myStr.getClass();

        Field charValueArr = null;

        try {
            charValueArr = classString.getDeclaredField("value");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println("Old Strin value: " + myStr);

        charValueArr.setAccessible(true);

        char[] array = {'z', 'x', 'c', 'w'};

        try {
            charValueArr.set(myStr, array);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("New string value: " + myStr);
        System.out.println("abcd");
    }
}
