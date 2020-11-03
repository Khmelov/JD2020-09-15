package by.it.dobrodey.calc;

import java.io.File;

public class GetFileName {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";

    private static final String FILENAME = getPath(Var.class) ;

    static String getFilename(){return FILENAME;}

    @SuppressWarnings("SameParameterValue")
    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC +
                File.separator + packageName;
    }
}
