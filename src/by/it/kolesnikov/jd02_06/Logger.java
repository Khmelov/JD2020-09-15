package by.it.kolesnikov.jd02_06;

/*
Вариант B. Доработайте логгер так, чтобы:
 Вариант А функционировал в составе учебного пакета calc но Singleton был реализован на
основе enum (see Joshua Bloch).
 Создание различных переменных (скаляров, векторов и т.д.) проводилось фабричным методом
• для этого метод в Var лучше перенести в отдельный класс VarCreator или аналогичный
• экземпляр этого класса можно передавать в парсер через инжекцию конструктором
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String LOG = "log.txt";

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

    private static String getFileName(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC +
                File.separator + packageName
                +File.separator + LOG;
    }

    void log(String log) {
        String filename = getFileName(Logger.class);
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.println(log);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
