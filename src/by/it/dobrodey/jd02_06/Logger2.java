package by.it.dobrodey.jd02_06;

import  java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

enum Logger2 {
    GET;

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
                + File.separator + LOG_NAME;
    }

    void log(String text) {
        String filename = getFileName(Logger1.class);
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.println(text + "    Time and Date:  " + LocalDateTime.now());
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}
