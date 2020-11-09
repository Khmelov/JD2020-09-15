package by.it.siarheikorbut.jd01_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/18ZAKGDaiKvwF1U0V06VUm6cKMQASZCRc/view?usp=sharing">Задание JD01_01</a>
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