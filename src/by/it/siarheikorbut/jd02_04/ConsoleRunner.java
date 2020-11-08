package by.it.siarheikorbut.jd02_04;

import java.io.*;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        try {
            Var.load();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        for (; ; ) {
            String expression = sc.nextLine();
            saveLogToTxt(expression);
            if (expression.equals("print var")) {
                System.out.println(Var.vars);
            }
            if (expression.equals("sort var")) {
                System.out.println(Var.sortMap());
            }
            if (expression.equals("end")) {
                break;
            }
            Var result = null;
            try {
                result = parser.calc(expression);
                saveLogToTxt(String.valueOf(result));
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                saveLogToTxt(e.getMessage());
            }
            printer.print(result);
        }
    }

    private static <e> void saveLogToTxt(String log) throws CalcException {
        String path = getPath() + "log.txt";
        int rowNumberInLog = 0;
        boolean flag = true;
        try (BufferedReader bf = new LineNumberReader(new FileReader(path))) {
            while (bf.readLine() != null) {
                rowNumberInLog++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (rowNumberInLog > 50) flag = false;
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, flag))) {
            writer.println(log);
        } catch (IOException e) {
            throw new CalcException(e);
        }
    }

    private static String getPath() {
        String rootProject = System.getProperty("user.dir");
        String relativePath = ConsoleRunner.class
                .getName()
                .replace(ConsoleRunner.class.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }
}