package _3._01;

/*
Читаем и пишем в файл: Human
Часто необходимо сохранять состояние работы программы.
До появления сериализации каждый делал это своим способом. В этой задаче нужно сохранить в файл
состояние работы программы и вычитать состояние из файла без использования сериализации.

Реализуй логику записи в файл и чтения из файла для класса Human.
Поле name в классе Human не может быть пустым.
Метод main реализован только для тебя и не участвует в тестировании.


Requirements:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список assets пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если поле name и список assets не пустые.
3. Класс Solution.Human не должен поддерживать интерфейс Serializable.
4. Класс Solution.Human должен быть публичным.
5. Класс Solution.Human не должен поддерживать интерфейс Externalizable.*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("src/_3/_01/file.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            System.out.println(ivanov.equals(somePerson));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (!Objects.equals(name, human.name)) return false;
            return Objects.equals(assets, human.assets);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                bufferedWriter.write(name + '\n');
                //bufferedWriter.newLine();

                //bufferedWriter.write(String.valueOf(assets.size()) + '\n');
                //bufferedWriter.newLine();

                for (Asset asset : assets) {
                    bufferedWriter.write(asset.getName() + " " + asset.getPrice() + '\n');
                    //bufferedWriter.newLine();
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                // Считываем имя человека
                name = bufferedReader.readLine();
                // Считываем каждый актив
                String assetLine;
                while ((assetLine = bufferedReader.readLine()) != null) {
                    String[] assetInfo = assetLine.split(" ");
                    String assetName = assetInfo[0];
                    double assetPrice = Double.parseDouble(assetInfo[1]);
                    assets.add(new Asset(assetName, assetPrice));
                }
            }
        }
    }
}

