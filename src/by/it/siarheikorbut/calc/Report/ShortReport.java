package by.it.siarheikorbut.calc.Report;

import by.it.siarheikorbut.calc.ConsoleRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ShortReport extends ReportBuilder {

    private final static String fileNameLog = "log.txt";

    @Override
    public void buildHeader() {
        report.setHeaderReport("Отчет о работе калькулятора (КРАТКИЙ)\nВремя начала работы: " + ConsoleRunner.DATE_START.toString());
    }

    @Override
    public void buildBody() {
        StringBuilder sbLog = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(getFileName()))) {
            while (br.ready()) {
                sbLog.append(br.readLine()).append("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        report.setBodyReport(sbLog.toString());
    }

    @Override
    public void buildFooter() {
        report.setFooterReport("Время конца работы работы: " + ConsoleRunner.DATE_FINISH.toString() + "\n");
    }

    private static String getFileName() {
        String rootProject = System.getProperty("user.dir");
        String path = ConsoleRunner.class.getName().
                replace(ConsoleRunner.class.getSimpleName(), "").
                replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + path + ShortReport.fileNameLog;
    }
}