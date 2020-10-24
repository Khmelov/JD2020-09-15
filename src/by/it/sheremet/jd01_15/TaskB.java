package by.it.sheremet.jd01_15;

import java.io.*;

public class TaskB {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String FILE_TASK_B_JAVA = "TaskB.java";
    private static final String RESULT_TASK_B = "TaskB.txt";


    /** первый многострочный
     * коментарий
     * @param - входная строка(с числами)
     */
    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName;
    }


    public static void main(String[] args) {
        String fileName = getPath(TaskB.class) + FILE_TASK_B_JAVA;
        StringBuilder readsJavaText = new StringBuilder();
        readJavaText(fileName, readsJavaText);
        String fileNameTxt = getPath(TaskB.class) + RESULT_TASK_B;
        printToFile(readsJavaText.toString(), fileNameTxt);
    }
    /*второй
    многострочный*/

    //первый однострочный
    private static void readJavaText(String fileName, StringBuilder stringBuilder) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)))
        {
        String line = bufferedReader.readLine();
        boolean ins = false;
        while (line != null){
        String trimLine = line.trim();
        String lineOut = line + "\n";
            if(ins){
                lineOut = "";
                if( trimLine.endsWith("*/")){
                    ins = false;
            }
                }else if( trimLine.startsWith("/*") || trimLine.startsWith("/**")) {
                    lineOut = lineOut.substring(0, lineOut.indexOf("/")) + "\n";
                    ins = true;
                    } else if (trimLine.startsWith("/"+"/")) {
                        lineOut = lineOut.substring(0, lineOut.indexOf("/" + "/")) + "\n";
                    }

                         stringBuilder.append(lineOut);
                         line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    //второй однострочный
    }
    private static void printToFile(String str, String fileNameTxt) {
        try(PrintWriter printWriter = new PrintWriter(fileNameTxt)) {
            printWriter.print(str);
        } catch (IOException io) {
            throw new RuntimeException(io);
        }
    }
}
