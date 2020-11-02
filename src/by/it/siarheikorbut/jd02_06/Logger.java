package by.it.siarheikorbut.jd02_06;

import java.io.*;

public class Logger {

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

    private static String dir(String simpleName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = Logger.class.getName().replace(Logger.class.getSimpleName(), "").replace(".", File.separator);
        return path + classDir + simpleName;
    }

    public void log(String line) {
        String filename = "log.txt";
        String fileName = dir(filename);
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}