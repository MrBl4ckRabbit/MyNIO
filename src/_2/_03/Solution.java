package _2._03;

/*
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.


Requirements:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in))) {
            String file = br.readLine();

            try (BufferedReader bufR = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bufR.readLine()) != null) {
                    System.out.println(line);
                    String[] words = line.split(",");
                    for (String word : words) {
                        if (word.equals("world")) {
                            count++;
                        }
                    }
                }
                System.out.println(count);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

