package _3._08;

/*
Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуй объект в методе getOriginalObject так, чтобы в случае возникновения исключения было выведено сообщение на экран и возвращен null.
Реализуй интерфейс Serializable где необходимо.


Requirements:
1. Класс B должен быть потомком класса A.
2. Класс A должен поддерживать интерфейс Serializable.
3. Класс B не должен явно поддерживать интерфейс Serializable.
4. Метод getOriginalObject должен возвращать объект типа A полученный из потока ObjectInputStream.
5. Метод getOriginalObject должен возвращать null, если при попытке десериализации не был получен объект типа A.
6. Метод getOriginalObject должен возвращать null, если при попытке десериализации возникло исключение.*/

import java.io.*;

public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            Object desObject = objectStream.readObject();
            if (desObject instanceof A) {
                return (A) desObject;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static class A implements Serializable {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            return true;
        }
    }

    public static class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/_3/_08/file.txt"));
             ObjectInputStream bis = new ObjectInputStream(new FileInputStream("src/_3/_08/file.txt"))) {
            A a1 = new A();
            oos.writeObject(a1);
            A a2 = (A) bis.readObject();

            System.out.println(a1.equals(a2));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
