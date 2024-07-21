package _2._04;

/*
Исправить ошибку. Классы и интерфейсы
Программа содержит всего 1 логическую ошибку.
Найди и исправь ее.


Requirements:
1. Класс Solution должен содержать интерфейс Example.
2. Класс Solution должен содержать класс A который реализует интерфейс Example.
3. Класс Solution должен содержать класс B который реализует интерфейс Example.
4. Класс Solution должен содержать класс C который наследуется от класса A.
5. Исправь всего одну логическую ошибку.*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
    static {
        System.out.println("This is the Solution class");
    }

    public static void main(String[] args) throws IOException {
        try (
                FileOutputStream outputStream = new FileOutputStream(args[0]);
                InputStream is = Solution.class.getClassLoader().getResourceAsStream(args[1])
        ) {
            assert is != null;
            byte[] b = new byte[is.available()];
            outputStream.write(is.read(b));

            int value = 123_456_789;
            System.out.println(value);

            Example result = null;
            String s = "a";
            switch (s) {
                case "a": {
                    result = new A();
                    break;
                }
                case "b": {
                    result = new B();
                    break;
                }
                case "c": {
                    result = new C();
                    break;
                }
            }

            if (result instanceof C) {
                C p = (C) result;
                System.out.println(p.getClass().getSimpleName());
            }

        } catch (IOException e) {
        }
    }

    interface Example {
    }

    static class A implements Example {
        static {
            System.out.println("This is the A class");
        }
    }

    static class B implements Example {
        static {
            System.out.println("This is the B class");
        }
    }

    static class C extends A {
        static {
            System.out.println("This is the C class");
        }
    }
}

//поменял все на статик, добавил [] в main, в проверке на 54 строке поменял на С