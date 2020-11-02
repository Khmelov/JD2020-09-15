package by.it.fedorinhyk.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public enum Logger {
    LOGGER;
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String RESULT_NAME = "log.txt";

    @SuppressWarnings("SameParameterValue")
    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName+File.separator+RESULT_NAME;
    }

    void log(String ResultText) throws CalcException {
        String filename = getPath(Logger.class);
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(LocalDateTime.now()));
            out.println(ResultText);
        } catch (IOException e) {
            throw new CalcException("ERROR: ", e);
        }
    }
}
