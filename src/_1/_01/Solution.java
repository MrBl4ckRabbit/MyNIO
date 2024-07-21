package _1._01;

/*
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Requirements:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.*/

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int maxByte = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(br.readLine())) {
            while (fis.available() > 0) {
                int temp = fis.read();
                if (temp > maxByte) {
                    maxByte = temp;
                }
            }
            System.out.println(maxByte);
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}
//src/_1/_01/file1.txt  лучше указать этот адрес. без полного пути выдаёт ошибку
//ответ 100 потому что 100 в аски это d