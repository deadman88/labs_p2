package DemoSerialize;

import java.io.*;

/**
 * Created by stas on 07.08.2017.
 */
public class DeserializeDemo {
    public static void main(String[] args) {
        Employee employee;
        try {
            FileInputStream fis = new FileInputStream("employee.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            employee = (Employee) ois.readObject();
            System.out.println(employee.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
