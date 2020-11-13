package by.it.zubovich.calcToTests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

class Logger {

    private static final String filename = "log.txt";
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

    public void log(String text) throws CalcException {
        String fn = getFileName(Logger.class, filename);

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(fn, true))
        ) {
            writer.println("Date&time: " + LocalDateTime.now() + " " + text);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            throw new CalcException("FILE ERROR: ", e);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static String getFileName(Class<?> aClass, String simpleName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path = path + aClass.getName().replace(".", File.separator);
        path = path.replace(aClass.getSimpleName(), "");
        return path + simpleName;
    }
}
