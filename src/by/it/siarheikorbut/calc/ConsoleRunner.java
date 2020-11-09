package by.it.siarheikorbut.calc;

import by.it.siarheikorbut.calc.Report.RunnerReport;

import java.io.*;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static Date DATE_START;
    public static Date DATE_FINISH;

    public static void main(String[] args) throws CalcException {
        DATE_START = new Date();
        ConsoleRunner cs = new ConsoleRunner();
        cs.clearLogs();
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        Lang resource = Lang.LANG;
        try {
            Var.load();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        for (; ; ) {
            String expression = sc.nextLine();
            saveLogToTxt(expression);
            if (expression.equals("ru")) {
                resource.setLocale(new Locale("ru", "RU"));
                continue;
            }
            if (expression.equals("be")) {
                resource.setLocale(new Locale("be", "BY"));
                continue;
            }
            if (expression.equals("en")) {
                resource.setLocale(new Locale("en", "UK"));
                continue;
            }
            if (expression.equals("print var")) {
                System.out.println(Var.vars);
                continue;
            }
            if (expression.equals("sort var")) {
                System.out.println(Var.sortMap());
                continue;
            }
            if (expression.equals("end")) {
                DATE_FINISH = new Date();
                break;
            }
            Var result = null;
            try {
                result = parser.calc(expression);
                saveLogToTxt(String.valueOf(result));
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                saveLogToTxt(e.getMessage());
                Logger.getInstance();
                Logger.log(e.getMessage());
            }
            printer.print(result);
        }
        RunnerReport.main(args);
    }

    private static void saveLogToTxt(String log) throws CalcException {
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

    private void clearLogs() throws CalcException {
        String pathLog = getPath() + "log.txt";
        String pathErr = getPath() + "log error.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathLog, false))) {
            writer.println("");
        } catch (IOException e) {
            throw new CalcException(e);
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathErr, false))) {
            writer.println("");
        } catch (IOException e) {
            throw new CalcException(e);
        }
    }
}