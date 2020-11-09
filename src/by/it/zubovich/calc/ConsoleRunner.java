package by.it.zubovich.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static Lang manager;
    public static void main(String[] args) {
        System.out.print(
                "Примеры выражений для расчета в консоли, а также деление на 0\n" +
                "3.8+26.2  " +
                "87.4-23.1  " +
                "1.04*5.9  " +
                "12.7*5  " +
                "6+12  " +
                "7*3.1  " +
                "4/8  " +
                "9-0.9  \n" +
                "{2,3,4}*2  " +
                "{2,3,4}/3  " +
                "{2,3,4}-5  " +
                "4+{2,3,4}  " +
                "{2,3,4}+{5,6,7} {2,3,4}-{5,6,7}\n" +
                "{{1,2},{8,3}}-2  " +
                "{{1,2},{8,3}}*{1,2}  " +
                "{{1,2},{8,3}}*{{1,2},{8,3}}  " +
                "{{1,2},{8,3}}+{{1,2},{8,3}}\n" +
                        "Введите/скопируйте выражения, для завершения наберите end:\n");
        Scanner sc = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = sc.nextLine()).equals("end")){
            try {
                Var result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
