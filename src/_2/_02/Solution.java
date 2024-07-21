package _2._02;

/*
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод


Requirements:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все символы из первого файла с четным порядковым номером (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        int count;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in))) {
            String file1 = br.readLine();
            String file2 = br.readLine();
            try (FileReader fr = new FileReader(file1);
                 FileWriter fw = new FileWriter(file2)) {

                for (int i = 1; fr.ready(); i++) {
                    count = fr.read();
                    if (i % 2 == 0) {
                        fw.write(count);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

