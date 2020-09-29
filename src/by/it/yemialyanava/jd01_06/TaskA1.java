package by.it.yemialyanava.jd01_06;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = p.matcher(Poem.text);
        while (matcher.find()){
            int start = matcher.start();
            text.setCharAt(start + 3,'#');
            if (matcher.group().length()>=7){
                text.setCharAt(start + 6,'#');
            }
        }
        System.out.println(text);
    }
}
