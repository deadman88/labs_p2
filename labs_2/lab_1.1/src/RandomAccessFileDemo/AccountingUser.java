package RandomAccessFileDemo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Created by stas on 07.07.2017.
 */
public class AccountingUser {
    private RandomAccessFile file;
        //на вхід методу передаємо імя користувача, якщо імя користувача вже присутнє в базі, то кількість його
        // відвідувань ми збільшуємо на одиницю, якщо імя унікальне, то метод записує його в кінець файлу
    public void testUsers(String nameUser){
        String str = ""; //зміна в яку ми будемо записувати зчитаний рядок файлу
        int bc = 0;     //зміна, яка буде збільшуватись при умові того, що імя користувача не унікальне
        try {
            //в циклі while перебираємо наш рядок за рядком до кінця
            while((str = file.readLine()) != null) {
                //розбиваємо стрічку на масив стрічок по :
                String[] strings = str.split(":");
                //якщо імя з файлу збігається з імям введеним в масиві, то блок проовжує своє виконання
                if(strings[0].equalsIgnoreCase(nameUser)){
                    //переводимо число в інт та збільшуємо на одиницю і перетворюємо назад в стрічку
                    int a = Integer.parseInt(strings[1]);
                    ++a;
                    strings[1] = Integer.toString(a);
                    //якщо вказівник знаходиться в кінці файлу то...
                    if(file.getFilePointer() == file.length()) {
                        file.seek(file.getFilePointer() - strings[0].length() - strings[1].length() - 1);
                        file.writeBytes(strings[0] + ":" + strings[1]);
                        //в усіх інших випадках
                    } else {
                        //file.seek() метод який пересуває вказівник у вказану точку
                        //пересуваємо вказівник на початок рядка (оскільки по дефолту в цей момент він буде
                        // знаходитись в його кінці)
                        //та методо writeBytes() записуємо в нього нашу змінену стрічку
                        file.seek(file.getFilePointer() - strings[0].length() - strings[1].length() - 2);
                        file.writeBytes(strings[0] + ":" + strings[1] + "\n");
                    }
                    bc++;
                }
            }
            //якщо bc=0 то це означає, що це новий користувач. записуємо його в кінеьц файлу
            if (bc==0){
                file.writeChars("\n" + nameUser + ":1" );
            }
            //в кінці роботи методу вказівник обовязково посуваєтсья на нульову позицію, щоб
            // з файлом можна було в подальшому номрально працювати
            file.seek(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //метод для виводу усіх рядків файлу на екран
    public void printFile(){
        String strings = "";
        try {
            //метод readLine() читає наступну стрічку(рядок) відносно вказівника
            while ((strings = file.readLine()) != null) {
                System.out.println(strings);
            }
            file.seek(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void finalize(){
        try {
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public AccountingUser(RandomAccessFile file) {
        this.file = file;
    }
}
