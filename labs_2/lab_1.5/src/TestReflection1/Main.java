package TestReflection1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by stas on 11.08.2017.
 */
public class Main {

    public static void main(String[] args) {

        MyClass myClass = new MyClass();
        Class c = myClass.getClass();
        int mod = c.getModifiers();

        System.out.println("Class name: " + c.getName());
        System.out.println();

        System.out.println("Modifiers:");
        if (Modifier.isPublic(mod))
            System.out.println("public");
        System.out.println();

        System.out.println("Fields: ");
        Field[] fields = c.getFields();
        System.out.println("Public fields: ");
        for (Field f : fields
                ) {
            if (Modifier.isPublic(f.getModifiers())) {
                System.out.println("Name: " + f.getName());
                System.out.println("Type: " + f.getType());
            }
        }
        System.out.println();

        fields = c.getDeclaredFields();
        System.out.println("All fields: ");
        for (Field f : fields
                ) {
            System.out.println("Name: " + f.getName());
            System.out.println("Type: " + f.getType());
        }
        System.out.println();

        Method[] methods_1 = c.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method m : methods_1
                ) {
            System.out.println("Name: " + m.getName());
            System.out.println("Return type: " + m.getReturnType());
            System.out.print("Param type: ");
            for (int i = 0; i < m.getParameterTypes().length; i++) {
                System.out.print(m.getParameterTypes()[i] + " ");
            }

            System.out.println();

        }
    }


}
