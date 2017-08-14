package TestReflection2;

import java.lang.reflect.Field;

/**
 * Created by stas on 14.08.2017.
 */
public class Main {

    public static void main(String[] args) {
        String myStr = "abcd";
        char[] value = new char[]{'z','x','c','v'};
        Class c = myStr.getClass();
        Field field = null;

        try {
            field = c.getDeclaredField("value");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println("Old: " + myStr);

        field.setAccessible(true);

        try {
            field.set(myStr, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("New: " + myStr);
    }
}

