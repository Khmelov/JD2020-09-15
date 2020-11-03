package by.it.yemialyanava.calcul;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum Logger {
    INSTANCE;

    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String LOG_NAME = "log.txt";

    private static String getFileName (Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName
                + File.separator + LOG_NAME;
    }

    void log(String logTxt){
        String fileName = getFileName(Logger.class);

        try(PrintWriter out = new PrintWriter(new FileWriter(fileName, true))){
            out.println(ConsoleRunner.manager.getCurrentDate() + logTxt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
