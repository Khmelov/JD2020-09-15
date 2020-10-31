package by.it.girovka.Kurs;

import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value;
        do {
            System.out.println("Введи 5");
            value = sc.nextInt();
        }while(value !=5);

        System.out.println("5");
    }
}
