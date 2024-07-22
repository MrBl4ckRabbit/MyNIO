package _3._03;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
Очень странные дела
При чтении/записи объектов типа Human возникают странные ошибки.
Разберись в чем дело и исправь их.


Requirements:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список assets равен null.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если поле name и список assets не равны null.
3. Класс Solution.Human не должен поддерживать интерфейс Serializable.
4. Класс Solution.Human должен быть публичным.
5. Класс Solution.Human не должен поддерживать интерфейс Externalizable.
6. Метод equals должен возвращать true для двух равных объектов типа Human и false для разных.
7. Метод hashCode должен всегда возвращать одно и то же значение для одного и того же объекта типа Human.*/

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            File your_file_name = new File("src/_3/_03/file.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
            inputStream.close();

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return false;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

//            if (name == null ? !name.equals(human.name) : human.name != null) return false;
//            return assets != null ? assets.equals(human.assets) : human.assets == null;
            if (!Objects.equals(name, human.name)) return false;// тут переопределил из первого задания.
            return Objects.equals(assets, human.assets);

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            //return (int) (Math.random() * 100); тут была какая-то дичь
            return result;
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
//            //implement this method - реализуйте этот метод
//            PrintWriter printWriter = new PrintWriter(outputStream);
//            printWriter.println(this.name);
//            if (this.assets.size() > 0) {
//                for (Asset current : this.assets)
//                    printWriter.println(current.getName());
//            }
//            printWriter.close();

            try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                bufferedWriter.write(name + '\n');
                //bufferedWriter.newLine();

                //bufferedWriter.write(String.valueOf(assets.size()) + '\n');
                //bufferedWriter.newLine();

                for (Asset asset : assets) {
                    bufferedWriter.write(asset.getName() + '\n');
                    //bufferedWriter.newLine();
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
//            //implement this method - реализуйте этот метод
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//
//            this.name = reader.readLine();
//            String assetName;
//            while ((assetName = reader.readLine()) != null)
//                this.assets.add(new Asset(assetName));
//            reader.close();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                // Считываем имя человека
                name = bufferedReader.readLine();
                // Считываем каждый актив
                String assetLine;
                while ((assetLine = bufferedReader.readLine()) != null) {
                    String[] assetInfo = assetLine.split(" ");
                    String assetName = assetInfo[0];
                    //double assetPrice = Double.parseDouble(assetInfo[1]);
                    assets.add(new Asset(assetName));
                }
            }
        }
    }
}


