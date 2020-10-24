package by.it.kolesnikov.jd01_14;

import java.io.File;

public class TaskC {

   private static final String SRC = "src";
   private static final String USER_DIR = "user.dir";

    public static void main(String[] args) {

    }

    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        //получаем корень проекта Root
        String property = System.getProperty(USER_DIR);
        return property + File.separator + SRC + File.separator + packageName;
    }
}
