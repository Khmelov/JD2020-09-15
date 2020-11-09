package by.it.siarheikorbut.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {

    private final static String fileName = "log.txt";

    private static volatile Logger logger;

    private Logger() {

    }

    static Logger getInstance() {
        Logger localLogger = Logger.logger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = Logger.logger;
                if (localLogger == null) {
                    logger = localLogger = new Logger();
                }
            }
        }
        return localLogger;
    }

    public static void log(String text) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(getFileName(), true))) {
            Date date = new Date();
            writer.println(date.toString() + " " + text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFileName() {
        String rootProject = System.getProperty("user.dir");
        String path = Logger.class.getName().
                replace(Logger.class.getSimpleName(), "").
                replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + path + Logger.fileName;
    }
}