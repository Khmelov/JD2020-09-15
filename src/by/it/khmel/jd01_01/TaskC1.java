package by.it.khmel.jd01_01;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должна появится в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
import java.util.Scanner;
class TaskC1 {
    public static void main(String[] args) {
        System.out.println("Enter number ");
        Scanner sc=new Scanner (System.in);
        int a=sc.nextInt();
        System.out.println("Enter number ");
        int b=sc.nextInt();
        System.out.println("Sum = "+ (a+b));
    }





}
