package by.it.frolova.testCalc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

public enum Logger {
    INSTANCE;

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    public static final String LOG_TXT = "log.txt";

    public void log(String logtxt) {

        Date date = new Date();
        String filename = getPath(Logger.class);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename, true))) {
            printWriter.printf("Action: %s Time: %s\n",
                    logtxt, printDate(date));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator +
                packageName + File.separator + LOG_TXT;
    }

    static String printDate(Date date) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        return dateFormat.format(date);

    }
}
