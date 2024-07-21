package _1._03;

/*
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Requirements:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(br.readLine());
             FileOutputStream fos = new FileOutputStream(br.readLine())) {
            while (fis.available() > 0) {
                list.add(fis.read());
            }
            Collections.sort(list);
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            Collections.reverse(list);

            for (Integer i : list) {
                fos.write(i);
                System.out.print(i + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
