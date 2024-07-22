package _3._02;

/*
Знакомство с properties
В методе main() происходит считывание пути к файлу с консоли и заполнение runtimeStorage данными из файла.
Тебе необходимо в методе save() реализовать логику записи в файл для карты runtimeStorage, а в методе load() - логику чтения из файла для runtimeStorage.
Файл должен быть в формате .properties. Комментарии в файле игнорируй.
Про .properties прочитай в вики.
Подсказка: используй объект класса Properties.


Requirements:
1. Метод save() должен сохранять карту runtimeStorage в параметр outputStream.
2. Метод load() должен восстанавливать состояние карты runtimeStorage из параметра inputStream.*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties properties = new Properties();

        for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        properties.store(outputStream, "store to properties file");
        outputStream.close();
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);//за метод спасибо сайту sky.pro)))))
        for (String s : properties.stringPropertyNames()) {
            String value = properties.getProperty(s);
            System.out.println(s + " = " + value);
            runtimeStorage.put(s, value);
        }
        inputStream.close();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos1 = new FileInputStream(reader.readLine());
             FileOutputStream fos2 = new FileOutputStream(reader.readLine())) {
            load(fos1);
            save(fos2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("************************************************");
        for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
            System.out.println(entry);
        }
    }
}


