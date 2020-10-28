package by.it.dobrodey.jd02_03;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class FileReadAndWrite {

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String BUYER_CHOOSE = "buyerChoose";
    static final String FILENAME = getPath(Buyer.class) + BUYER_CHOOSE;
    @SuppressWarnings("SameParameterValue")

     static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC +
                File.separator + packageName;
    }
     static void printInFile(String filename, Map<?, ?> map) {
        try (PrintWriter writer = new PrintWriter(filename )) {
            writer.println(map);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
