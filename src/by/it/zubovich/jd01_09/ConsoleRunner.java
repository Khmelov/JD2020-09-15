package by.it.zubovich.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        System.out.print(
                "Примеры выражений для расчета в консоли\n" +
                "Вариант А:\n" +
                "3.8+26.2  " +
                "87.4-23.1  " +
                "1.04*5.9  " +
                "12.7*5  " +
                "6+12  " +
                "7*3.1  " +
                "4/8  " +
                "9-0.9  \n" +
                "Вариант B:\n" +
                "{2,3,4}*2  " +
                "{2,3,4}/3  " +
                "{2,3,4}-5  " +
                "4+{2,3,4}  " +
                "{2,3,4}+{5,6,7} {2,3,4}-{5,6,7}\n" +
                "Вариант С:\n" +
                "{{1,2},{8,3}}-2  " +
                "{{1,2},{8,3}}*{1,2}  " +
                "{{1,2},{8,3}}*{{1,2},{8,3}}  " +
                "{{1,2},{8,3}}+{{1,2},{8,3}}\n" +
                        "Введите или скопируйте выражения, для завершения наберите end:\n");
        Scanner sc = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = sc.nextLine()).equals("end")){
            Var result = parser.calc(line);
            printer.print(result);
        }
    }
}
