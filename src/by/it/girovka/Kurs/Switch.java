package by.it.girovka.Kurs;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ваш возраст: ");
        int age = sc.nextInt();
        switch (age){
            case 0:
                System.out.println("рождение");
                break;
            case 7:
                System.out.println("ты школьник ");
                break;
            case 18:
                System.out.println("ты сдунет");
                break;
            default:
                System.out.println("ты никто");
        }
    }
}
