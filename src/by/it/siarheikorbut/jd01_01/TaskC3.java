package by.it.siarheikorbut.jd01_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Ускорение свободного падения на Земле и Марсе таково:
Марс   3.86
Земля   9.81

С клавиатуры вводится вес человека в килограммах.
Рассчитайте вес человека на Марсе и выведите
округлив его до сотых килограмма (2 знака)

Создайте для этих целей метод getWeight(int weight)

Требования:
1. Метод getWeight(int weight) должен быть статическим.
2. Метод getWeight должен возвращать значение типа double.
3. Метод getWeight должен обязательно (!) округлять до сотых возвращаемое значение типа double.
4. Метод getWeight не должен ничего выводить на экран.
5. Метод getWeight должен правильно переводить вес тела в килограммах на Земле
    в вес этого же тела на Марсе, и возвращать это значение.

Пример:

Ввод:
75

Вывод:
29.51


*/

class TaskC3 {
    public static void main(String[] args) throws IOException {

        //Ввод с клавиатуры веса человека в кг. и вывод на экран.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int weight = Integer.parseInt(reader.readLine());
        System.out.println(getWeight(weight));
    }

    //Расчет веса человека на Марсе и округление до сотых.
    public static double getWeight(int weight) {

        double marsSpeed = 3.86;
        double earthSpeed = 9.81;
        double marsWeight = weight / earthSpeed * marsSpeed;
        return Math.round(marsWeight * 100.0) / 100.0;
    }
}
