package _1._04;

/*
DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки работы с файлами.
2.2 Выбросить исключение DownloadException.


Requirements:
1. Программа должна считать имена файлов с консоли.
2. Для чтения из файлов используй поток FileInputStream.
3. Программа должна работать, пока введенный файл не окажется меньше 1000 байт.
4. Программа должна завершиться исключением DownloadException.
5. Поток FileInputStream должен быть закрыт.*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(br.readLine())) {
            while (fis.available() > 0) {
                if (fis.available() < 100) {
                    throw new DownloadException("The file is too small");
                } else {
                    System.out.println("The file is OK");
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class DownloadException extends Exception {
        DownloadException(String message) {
            super(message);
        }
    }
}

