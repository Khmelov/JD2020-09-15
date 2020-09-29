package by.it.hutnik.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuffer text = new StringBuffer(Poem.text);
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(text);
        while ((matcher.find())) {
            System.out.println();


        }



        //System.out.println(Poem.text);
    }
}
