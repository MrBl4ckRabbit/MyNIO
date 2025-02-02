package _3._11;

import java.io.*;

/*
Сериализация под запретом
Запрети сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя.


Requirements:
1. Класс Solution должен поддерживать интерфейс Serializable.
2. Класс SubSolution должен быть создан внутри класса Solution.
3. Класс SubSolution должен быть потомком класса Solution.
4. При попытке сериализовать объект типа SubSolution должно возникать исключение NotSerializableException.
5. При попытке десериализовать объект типа SubSolution должно возникать исключение NotSerializableException.*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream in) throws IOException {
            throw new NotSerializableException();
        }
    }
    /*Чтобы не допустить автоматическую сериализацию можно переопределить private методы
    для создания исключительной ситуации NotSerializableException .
    Любая попытка записать или прочитать этот объект теперь приведет к возникновению исключительной ситуации.*/

    public static void main(String[] args) {

    }
}

