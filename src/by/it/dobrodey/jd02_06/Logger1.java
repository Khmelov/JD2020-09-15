package by.it.dobrodey.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

class Logger1 {

    private static volatile Logger1 logger;

    private Logger1() {

    }

    static Logger1 getLogger() {
        Logger1 result = logger;
        if (result == null) {
            synchronized (Logger1.class) {
                result = logger;
                if (result == null) {
                    result = logger = new Logger1();
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

    void log(String text) {
        String filename = getFileName(Logger1.class);
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.println(text+"    Time and Date:  "+ LocalDateTime.now());
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}
