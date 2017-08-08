package RandomAccessFileDemo;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by stas on 07.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("users.txt", "rw")) {
            AccountingUser accountingUser = new AccountingUser(raf);
            accountingUser.testUsers("Ivan");
            System.out.println("Result:");
            accountingUser.printFile();
        }catch (IOException e){
            System.out.println(e);
        }

    }
}
