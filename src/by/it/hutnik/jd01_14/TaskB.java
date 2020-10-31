package by.it.hutnik.jd01_14;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String TEXT_TXT = "text.txt";
    public static final String RESULT_TASK_B_TXT = "resultTaskB.txt";

    public static void main(String[] args) {
        String path = getPath();
        String fileName = path + TEXT_TXT;
        ArrayList<String> strings = new ArrayList<>();
        getRead(fileName,strings);
        System.out.println(strings);
        getMath(strings,path);
    }

    private static void getMath(ArrayList<String> strings, String path) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : strings) {
            stringBuffer.append(string);
            stringBuffer.append(' ');
        }
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Pattern patt = Pattern.compile("[,:;?()!\\-\\.]+");
        Matcher matcher1 = pattern.matcher(stringBuffer);
        Matcher matcher = patt.matcher(stringBuffer);
        int words = 0,marks = 0;
        HashSet<String> temp = new HashSet<>();
        while (matcher1.find())words++;
        while (matcher.find()){
            marks++;}
        System.out.println("words="+words+", punctuation marks="+marks);
        try (PrintWriter printWriter=new PrintWriter(path+RESULT_TASK_B_TXT)){
            printWriter.println("words="+words+", punctuation marks="+marks);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getRead(String fileName, ArrayList<String> strings) {
        try (BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            while (bufferedReader.ready()){
                strings.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath() {
        String projectDir = System.getProperty("user.dir");
        String relativePath = TaskB.class.getName()
                .replace(TaskB.class.getSimpleName(), "")
                .replace(".", File.separator);
        return projectDir + File.separator + "src" + File.separator + relativePath;
    }
}
