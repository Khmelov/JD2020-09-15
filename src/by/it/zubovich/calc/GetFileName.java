package by.it.zubovich.calc;

import java.io.File;

public class GetFileName {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";

    private static final String FILENAME = getPath() ;

    static String getFilename(){return FILENAME;}

    private static String getPath() {
        String packageName = Var.class
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC +
                File.separator + packageName;
    }
}
