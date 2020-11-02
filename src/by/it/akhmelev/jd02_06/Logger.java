package by.it.akhmelev.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {

    private static volatile Logger logger;

    private Logger() {

    }

    static Logger getLogger() {
        Logger result = logger;
        if (result == null) {
            synchronized (Logger.class) {
                result = logger;
                if (result == null) {
                    result = logger = new Logger();
                }
            }
        }
        return result;
    }

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String LOG_NAME = "log.txt";

    @SuppressWarnings("SameParameterValue")
    private static String getFileName(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC +
                File.separator + packageName
                +File.separator + LOG_NAME;
    }

    void log(String logtxt) {
        String filename = getFileName(Logger.class);
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.println(logtxt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
