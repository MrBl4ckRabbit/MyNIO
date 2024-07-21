package _1._06;

/*
Поиск данных внутри файла
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде,
в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

Информация по каждому товару хранится в отдельной строке.

Пример содержимого файла:
194 хлеб 12.6 25
195 масло сливочное 52.2 12
196 молоко 22.9 19

Пример вывода для id = 195:
195 масло сливочное 52.2 12


Requirements:
1. Программа должна считать имя файла с консоли.
2. Создай для файла поток для чтения.
3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
4. Поток для чтения из файла должен быть закрыт.*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //для ввода данных с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

       //для чтения данных из файла
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
            String line;
            int targetId = Integer.parseInt(args[0]);

            while ((line = fileReader.readLine()) != null) {
                String[] parts = line.split(" ");
                int id = Integer.parseInt(parts[0]);

                if (id == targetId) {
                    System.out.println(line);
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println( e.getMessage());
        }
    }
}
//перед запуском обязательно нужно проверить установлены ли параметры!!!!!
