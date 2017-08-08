package DemoSerialize;

import java.io.*;

/**
 * Created by stas on 07.08.2017.
 */
public class SerializeDemo {
    public static void main(String[] args) {

        Employee employee = new Employee("one","two", 123456);
        try {
            FileOutputStream fos = new FileOutputStream("employee.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
