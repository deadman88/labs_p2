package DemoSerialize;

import java.io.Serializable;

/**
 * Created by stas on 07.08.2017.
 */
public class Employee implements Serializable {
    private String name;
    private String address;
    private transient int SSN;

    public Employee(String name, String address, int SSN) {
        this.name = name;
        this.address = address;
        this.SSN = SSN;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", SSN=" + SSN +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }
}
