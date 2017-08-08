package PrintFile;

import java.io.*;

/**
 * Created by stas on 06.07.2017.
 */
public class PrintFile {
    public static void main(String[] args) {
        String path = args.length == 0 ? "printFile.txt":args[0]; //якщо аргументів нуль зчитуємо файл прінтФайл
        File file = new File(path);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String str = "";
            while ((str = bufferedReader.readLine()) != null){
                System.out.println(str);
            }
//            int b = 0;
//        while((b = fileReader.read()) != -1){ // -1 повертається коли порожній потік
//            System.out.print((char)b);
//        }
        }catch (FileNotFoundException e ){
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
