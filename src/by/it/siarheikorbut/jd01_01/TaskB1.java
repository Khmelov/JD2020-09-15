package by.it.siarheikorbut.jd01_01;

import java.util.Scanner;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/18ZAKGDaiKvwF1U0V06VUm6cKMQASZCRc/view?usp=sharing">Задание JD01_01</a>
 */

class TaskB1 {
    public static void main(String[] args) {

        //Считывание с клавиатуры целого числа и вывод квадрата этого числа на экран.
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = i * i;
        System.out.println(j);
    }
}