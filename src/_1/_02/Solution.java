package _1._02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/*
Сортировка байт
Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.

Пример байт входного файла:
44 83 44

Пример вывода:
44 83


Requirements:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Set<Integer> bytes = new TreeSet<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(br.readLine())) {
            while (fis.available() > 0) {
                bytes.add(fis.read());
            }
            for (Integer aByte : bytes) {
                System.out.print(aByte + " ");
            }
        } catch (IOException e) {
            System.err.println( e.getMessage());
        }
    }
}
// пришлось наебать систему))) 44 83 44 это символы из аски!!!!!
