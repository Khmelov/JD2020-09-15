package by.it.siarheikorbut.calc.Report;

import by.it.siarheikorbut.calc.ConsoleRunner;

import java.io.*;

public class LongReport extends ReportBuilder {

    private final static String fileNameLog = "log.txt";

    private final static String fileNameErr = "log error.txt";

    @Override
    public void buildHeader() {
        report.setHeaderReport("Отчет о работе калькулятора (ПОЛНЫЙ)\nВремя начала работы: " + ConsoleRunner.DATE_START.toString());
    }

    @Override
    public void buildBody() {
        StringBuilder sbLog = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(getFileName(fileNameLog)))) {
            while (br.ready()) {
                sbLog.append(br.readLine()).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuilder sbErr = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(getFileName(fileNameErr)))) {
            while (br.ready()) {
                sbErr.append(br.readLine()).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        report.setBodyReport(sbLog.toString() + "\nОтчет от ошибках:" + sbErr.toString());
    }

    @Override
    public void buildFooter() {
        report.setFooterReport("Время конца работы работы: " + ConsoleRunner.DATE_FINISH.toString() + "\n");
    }

    private static String getFileName(String simpleName) {
        String rootProject = System.getProperty("user.dir");
        String path = ConsoleRunner.class.getName().
                replace(ConsoleRunner.class.getSimpleName(), "").
                replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + path + simpleName;
    }
}