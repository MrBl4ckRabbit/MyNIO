package _3._10;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
Исправить ошибку. Сериализация
После десериализации объекта класса Solution обнаружили, что данных в словаре [m] нет :(

Исправить 1 ошибку.


Requirements:
1. В классе Solution должен существовать конструктор без параметров.
2. В классе Solution должен существовать метод size без параметров.
3. В классе Solution метод size должен возвращать значение типа int.*/

public class Solution implements Serializable {


    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("src/_3/_10/file.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //load
        FileInputStream fiStream = new FileInputStream("src/_3/_10/file.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public  Solution() {
        m.put("Mickey", "Mouse");
        m.put("Micke", "Mantle");
    }

    public int size() {
        return m.size();
    }

}

