package by.it.siarheikorbut.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/184w9bSZcb6EcCcpfp_ff1nl2atlGKnpz/view?usp=sharing">Задание JD01_06</a>
 */

public class TaskA2 {
    private static String[] uniqueWords = {};
    private static int[] counters = {};

    public static void main(String[] args) {

        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            System.out.println(word);
            processOneWord(word);
        }
        for (int i = 0; i < uniqueWords.length; i++) {
            System.out.printf("%s=%d\n", uniqueWords[i], counters[i]);
        }
    }

    private static void processOneWord(String word) {
        for (int i = 0; i < uniqueWords.length; i++) {
            if (uniqueWords[i].equals(word)) {
                counters[i]++;
                return;
            }
        }
        uniqueWords = Arrays.copyOf(uniqueWords, uniqueWords.length + 1);
        counters = Arrays.copyOf(counters, counters.length + 1);
        uniqueWords[uniqueWords.length - 1] = word;
        counters[counters.length - 1] = 1;
    }
}