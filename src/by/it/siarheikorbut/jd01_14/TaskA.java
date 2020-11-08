package by.it.siarheikorbut.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1HyLarqxY-TWlB5f_c1_zolEUaMh5gd7T/view?usp=sharing">Задание JD01_14</a>
 */

public class TaskA {

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    public static final String FILE_DATA = "dataTaskA.bin";
    private static final String RESULT_TASK_A = "resultTaskA.txt";

    private static String getPath() {
        String packageName = TaskA.class
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName;
    }

    public static void main(String[] args) {
        String filename = getPath() + FILE_DATA;
        writeRandomInt(filename);
        List<Integer> list = new ArrayList<>();
        readInt(filename, list);
        printToConsole(list);
        String filenameTxt = getPath() + RESULT_TASK_A;
        printToFile(list, filenameTxt);
    }

    private static void writeRandomInt(String filename) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(filename)
                        )
                )
        ) {
            for (int i = 0; i < 20; i++) {
                int n = -12345 / 2 + (int) (Math.random() * 12345);
                dataOutputStream.write(n);
            }
            dataOutputStream.writeInt(90 + (89 << 8) + (88 << 16) + 87 * 256 * 256 * 256);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readInt(String filename, List<Integer> list) {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            while (dataInputStream.available() > 0) {
                list.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer integer : list) {
            System.out.print(integer + " ");
            sum += integer;
        }
        System.out.println("\navg=" + sum / list.size());
    }

    private static void printToFile(List<Integer> list, String filenameTxt) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(filenameTxt);
            double sum2 = 0;
            for (Integer integer : list) {
                printWriter.print(integer + " ");
                sum2 += integer;
            }
            printWriter.println("\navg=" + sum2 / list.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(printWriter)) {
                printWriter.close();
            }
        }
    }
}