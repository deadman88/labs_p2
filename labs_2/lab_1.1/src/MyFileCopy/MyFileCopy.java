package MyFileCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by stas on 07.07.2017.
 */
public class MyFileCopy {
    public static void main(String[] args) {
        String path1 = "forPath1.txt";
        String path2 = "forPath2.txt";
        File file1 = new File(path1);
        File file2 = new File(path2);
        try (FileInputStream fis = new FileInputStream(file1);
             FileOutputStream fos = new FileOutputStream(file2)) {
            int a = 0;
            while ((a = fis.read())!=-1) {
                fos.write((char) a);
                fos.flush();
            }
        }catch (IOException e ){
            System.out.println(e);
        }
    }
}
