package by.it.siarheikorbut.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/184w9bSZcb6EcCcpfp_ff1nl2atlGKnpz/view?usp=sharing">Задание JD01_06</a>
 */

public class TaskB1 {

    private static final String glass = "ауоыиэяюёеАУОЫИЭЯЮЕЁ";

    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m1 = p1.matcher(Poem.text);
        while (m1.find()) {
            String word = m1.group();
            int length = m1.end() - m1.start();
            if (equalFirstLastLetter(word, length)) System.out.println(word);
        }
    }

    private static boolean equalFirstLastLetter(String word, int length) {

        return (TaskB1.glass.indexOf(word.charAt(0)) < 0 && TaskB1.glass.indexOf(word.charAt(length - 1)) >= 0);
    }
}