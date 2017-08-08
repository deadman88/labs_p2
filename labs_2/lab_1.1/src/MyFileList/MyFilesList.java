package MyFileList;

import java.io.File;
import java.io.IOException;

/**
 * Created by stas on 06.07.2017.
 */
public class MyFilesList {
    public static void main(String[] args) {
        String path = args.length == 0 ? "." : args[0]; //якшо аргументів нуль то береться поточний каталог
                                                        //якщо ні - береться нульовий аргумент
        File f = new File(path); //зчитування даних з поточного каталогу
        if (f.exists()) { //перевірка на існування такого шляху, якщо шлях існує - йдемо далі
            String[] files = f.list(); // в масив стрічок вносимо список файлів в каталогу
            if (files != null) {
                for (String fileNames : files) { //в циклі for each виводимо всі назви каталогів на екран
                    System.out.println(fileNames);
                }
            }
        } else {
            System.out.println(f + " does not exists");
        }
        //для запуску - запускаємо Run... і там виставляємо Arguments наприклад c:// - виведе всі папки в диску с
    }
}
