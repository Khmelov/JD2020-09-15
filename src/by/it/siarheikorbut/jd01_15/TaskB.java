package by.it.siarheikorbut.jd01_15;

import java.io.*;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1fFm7gNQmkZDkGzNKxCvW1mcL5un0ceFg/view?usp=sharing">Задание JD01_15</a>
 */

public class TaskB {
    private static final String FILE_TASK_B_JAVA = "TaskB.java";
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String RESULT_TASK_B = "TaskB.txt";

    private static String getPath() {
        String packageName = TaskB.class
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName;
    }

    public static void main(String[] args) {
        String fileName = getPath() + FILE_TASK_B_JAVA;
        StringBuilder readJavaText = new StringBuilder();
        readJavaText(fileName, readJavaText);
        String fileNameTxt = getPath() + RESULT_TASK_B;
        printToFile(readJavaText.toString(), fileNameTxt);
    }

    private static void readJavaText(String fileName, StringBuilder stringBuilder) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            boolean insideBlock = false;
            while (line != null) {
                String timeline = line.trim();
                String lineToOutput = line + "\n";
                if (insideBlock) {
                    lineToOutput = "";
                    if (timeline.endsWith("*/")) {
                        insideBlock = false;
                    }
                } else {
                    if (timeline.startsWith("/" + "/")) {
                        lineToOutput = lineToOutput.substring(0, lineToOutput.indexOf("/" + "/")) + "\n";
                    } else if (timeline.startsWith("/*") || timeline.startsWith("/**")) {
                        lineToOutput = lineToOutput.substring(0, lineToOutput.indexOf("/")) + "\n";
                        insideBlock = true;
                    }
                }
                stringBuilder.append(lineToOutput);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printToFile(String str, String fileNameTxt) {
        try (PrintWriter printWriter = new PrintWriter(fileNameTxt)) {
            printWriter.print(str);
        } catch (IOException io) {
            throw new RuntimeException(io);
        }
    }
}
