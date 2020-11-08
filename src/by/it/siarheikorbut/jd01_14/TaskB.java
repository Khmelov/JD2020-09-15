package by.it.siarheikorbut.jd01_14;

import java.io.File;
import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1HyLarqxY-TWlB5f_c1_zolEUaMh5gd7T/view?usp=sharing">Задание JD01_14</a>
 */

public class TaskB {

    public static final String TEXT_TXT = "text.txt";
    public static final String RESULT_TASK_B_TXT = "resultTaskB.txt";

    private static String getPath() {
        String packageName = TaskB.class
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty("user.dir");
        return root + File.separator + "src" + File.separator + packageName;
    }

    public static void main(String[] args) {
        String filename = getPath() + TEXT_TXT;
        String resultantly = getPath() + RESULT_TASK_B_TXT;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int sumMars = 0;
            int sumWord = 0;
            String line = reader.readLine();
            while (line != null) {
                line = line.replaceAll("(\\.{3})", ".");
                Pattern patternWord = Pattern.compile("[А-Яа-яЁё]+");
                Matcher matcherWord = patternWord.matcher(line);
                Pattern patternMark = Pattern.compile("[?!,;:.-]");
                Matcher matcherMark = patternMark.matcher(line);
                while (matcherWord.find()) {
                    sumWord++;
                }
                while (matcherMark.find()) {
                    sumMars++;
                }
                line = reader.readLine();
            }
            System.out.printf("words=%d, punctuation marks=%d", sumWord, sumMars);
            printToFile(resultantly, sumWord, sumMars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printToFile(String resultantly, int sumWord, int sumMars) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(resultantly);
            printWriter.printf("words=%d, punctuation marks=%d", sumWord, sumMars);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(printWriter)) {
                printWriter.close();
            }
        }
    }
}