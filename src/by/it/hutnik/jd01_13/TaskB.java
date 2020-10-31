package by.it.hutnik.jd01_13;

import java.util.Scanner;

class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        double res = 0;
        try {
        while (!(str= scanner.nextLine()).equals("END")){
            double value = Double.parseDouble(str);
            System.out.println(value);
            res += value;
            double m =Math.sqrt(res);
            if (Double.isNaN(m)) throw  new ArithmeticException();
            System.out.println(m);
            }
        }catch (ArithmeticException | NumberFormatException e){
            String eName = e.getClass().getName();
            StackTraceElement[] sTrace = e.getStackTrace();
            for (StackTraceElement element : sTrace) {
                String mName = element.getMethodName();
                if (mName.equals("main")){
                    String className = element.getClassName();
                    int lNumber = element.getLineNumber();
                    System.out.printf("  name: %s\n class: %s\n  line: %d\n",eName,className,lNumber);
                    break;
                }
            }
        }
    }
}