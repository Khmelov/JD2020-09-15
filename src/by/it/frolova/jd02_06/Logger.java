package by.it.frolova.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

public class Logger {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    public static final String LOG_TXT = "log.txt";
    private static volatile Logger logger;

    private Logger() {
    }

    static Logger getLogger() {
        Logger thisLogger = logger;
        if (thisLogger == null) {
            synchronized (Logger.class) {
                thisLogger = logger;
                if (thisLogger == null) {
                    thisLogger = logger = new Logger();
                }
            }
        }
        return thisLogger;
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

    public void log(String logtxt) {
        String filename = getPath(Logger.class);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename, true))) {
            printWriter.println(logtxt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String printDate(Date date) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        return dateFormat.format(date);
    }
}
