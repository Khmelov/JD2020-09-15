package by.it.zubovich.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();
        System.out.println("введите номер месяца:");
        Scanner sc = new Scanner(System.in);
        int month = sc.nextByte();
        step2(month);
        System.out.println();
        System.out.println("эээм...сейчас будем решать...квадратное уравнение):");
        System.out.println("введите 3 переменные - a, b, c - после ввода каждой - Enter:");
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        step3(a, b, c);
    }

    private static void step1() {
        System.out.println();
        int t = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%02d", t++);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }
    }

    private static void step3(double a, double b, double c) {
        double x, x1, x2;
        double discriminant = (b * b - 4 * a * c);
        if (a != 0) {
            if (discriminant > 0) {
                x1 = ((-b) - Math.sqrt(discriminant)) / (2 * a);
                x2 = ((-b) + Math.sqrt(discriminant)) / (2 * a);
                System.out.println("так как дискриминант больше нуля, имееем 2 корня:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
            else if (discriminant < 0) {
                System.out.println("дискриминант меньше нуля - делаем вывод о том, что корней на множестве действительных чисел нет...или");
                System.out.println("корней нет");
            }
            else if (discriminant == 0) {
                x = -(b / (2 * a));
                System.out.println("так как дискриминант равен нулю, то х1 = х2 = " + x);
            }
            else {
                System.out.println("что-то пошло не так...");
                System.out.println("...возможно...");
                System.out.println("корней нет");
            }
        }
        else {

            System.out.println("так как а = 0, уравнение не имеет решения");
            System.out.println("корней нет");
        }

    }
}
