package TestReflection1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by stas on 14.08.2017.
 */
public class Main2 {
    public static void main(String[] args) {
        Class myClass = null;
        try {
            myClass = Class.forName("TestReflection1.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        MyClass myClass1 = null;
        try {
            Constructor constructor = myClass.getDeclaredConstructor(int.class, int.class);
            myClass1 = (MyClass)constructor.newInstance(3,4);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Class<?>[]paramTypes = new Class[]{int.class};
        try {
            Method method = myClass.getMethod("setA",paramTypes);
            Object[] arguments = new Object[]{ Integer.valueOf(33)};
            method.invoke(myClass1,arguments);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("Class name: " + myClass.getName());
        System.out.println();
        Field[] fields = myClass.getDeclaredFields();

        System.out.println("All fields: ");
        for (Field f : fields
                ) {
            System.out.println("Name: " + f.getName());
            System.out.println("Type: " + f.getType());
            try {
                f.setAccessible(true);
                System.out.println("Value: " + f.get(myClass1));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
