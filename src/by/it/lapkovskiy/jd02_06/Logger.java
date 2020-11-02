package by.it.lapkovskiy.jd02_06;

import javafx.scene.input.DataFormat;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class Logger {
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";

    private String fileName = "log.txt";
    private static volatile Logger logger;

    private Logger() {

    }

    static Logger getInstance() {
        Logger localLogger = Logger.logger;
        if (logger == null) {
            synchronized (Logger.class) {
                localLogger = Logger.logger;
                if (localLogger == null)
                    logger = localLogger = new Logger();
            }
        }
        return localLogger;
    }

    public void log(String text) {
        String path = getPath(Logger.class, this.fileName);
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(path, true))
        ) {
            writer.println(text+": "+
                    (DateFormat.getDateInstance(DateFormat.LONG)
                    .format(new Time(new Date().getTime()))) +
                    LocalDateTime.now().getHour()+":"+
                    LocalDateTime.now().getMinute()+":"+
                    LocalDateTime.now().getSecond()+":"+
                    LocalDateTime.now().getNano()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<?> aClass, String FileName) {
        String path = System.getProperty(USER_DIR) + File.separator+ SRC + File.separator;
        path = path+ aClass.getName().replace(".",File.separator);
        path = path.replace(aClass.getSimpleName(),"");
        return path + FileName;
    }
}
