package by.it.hutnik.jd02_06;

import by.it._examples_.jd01_10.sample_proxylog.logger.Log;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String LOG_TXT = "log.txt";

    private final static String logtxtFile = LOG_TXT;

    private static volatile Logger logger;

    private Logger() {

    }

    static Logger getInstance(){
        Logger resalt = logger;
        if (logger == null){
            synchronized (Logger.class) {
                resalt = logger;
                if(resalt == null){
                    resalt = logger = new Logger();
                }
            }
        }
        return resalt;
    }

    private static String getFileName(Class<?> nameTaskA, String logtxtFile) {
        String userDir = System.getProperty(USER_DIR);
        String path = nameTaskA.getName().replace(nameTaskA.getSimpleName(),"").replace(".", File.separator);
        return userDir + File.separator + SRC + File.separator + path + logtxtFile;
    }

    public static void log (String logtxt){
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(getFileName(Logger.class, logtxtFile), true))) {
            Date date = new Date();
            printWriter.println(date.toString() + " " + logtxt);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
