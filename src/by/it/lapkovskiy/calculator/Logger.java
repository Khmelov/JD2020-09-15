package by.it.lapkovskiy.calculator;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;

enum  Logger {
    GET;
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";

    private String fileName = "log.txt";
    private static volatile Logger logger;

    private Logger() {

    }

    public void log(String text) {
        String path = getPath(Logger.class, this.fileName);
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(path, true))
        ) {
            writer.println(
                    (DateFormat.getDateInstance(DateFormat.LONG,ConsoleRunner.locale)
                    .format(new Time(new Date().getTime()))) +
                    LocalDateTime.now().getHour()+":"+
                    LocalDateTime.now().getMinute()+":"+
                    LocalDateTime.now().getSecond()+":"+
                    text
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void log(String text,String FileName) {
        String path = getPath(Logger.class, FileName);
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(path, true))
        ) {
            writer.println(text);
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
