package ReplacmentFiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by stas on 07.07.2017.
 */
public class ReplacmentFile {
    public static void main(String[] args) {
        //через клас Path вказуємо шлях до нашого методу
        // (логічно ж, клас ж так і називається "ШЛЯХ" шо він ше блять робив би)
        Path path = Paths.get("forReplacement.txt");
        try {
            FileReader fileReader = new FileReader(path.toFile());
            int ch = 0;
            StringBuilder  sb = new StringBuilder();
            //в циклі while перебираємо увесь файл і в зміну ch записуємо байти
            //append перетворює наші байти в стрінги(стрічки)
            while ((ch = fileReader.read()) !=-1){
                sb.append((char)ch);
            }
            //закриваємо fileReader щоб він не жер память
            fileReader.close();
            //заміняємо усі поля private на public та заносимо усе в str
            String str = sb.toString().replaceAll("private","public");
            FileWriter fileWriter = new FileWriter(path.toFile());
            //перезаписуємо нову в стрічку в файл
            fileWriter.write(str);
            fileWriter.close();
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e);
        }

    }
}
