package by.it.siarheikorbut.jd01_06;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/184w9bSZcb6EcCcpfp_ff1nl2atlGKnpz/view?usp=sharing">Задание JD01_06 ( С2 )</a>
 */

public class TaskC2 {
    public static void main(String[] args) {
        getArrayWord();

        long startSlow = System.nanoTime();
        String resultSlow = slow(Poem.text);
        long finishSlow = System.nanoTime();
        long durationSlow = (finishSlow - startSlow) / 1000000;

        System.out.printf("Длинна resultSlow=%d символа;", resultSlow.length());
        System.out.printf("Время выполнения resultSlow=%d мс;\n", durationSlow);
        System.out.println(resultSlow);

        long startFast = System.nanoTime();
        String resultFast = fast(Poem.text);
        long finishFast = System.nanoTime();
        long durationFast = (finishFast - startFast) / 1000000;

        System.out.printf("Длинна resultFast=%d символа;", resultFast.length());
        System.out.printf("Время выполнения resultFast=%d мс;", durationFast);
        System.out.println(resultFast);
        System.out.printf("Время выполнения resultFast=%d мс;", durationFast);
    }

    private static String fast(String text) {
        String[] arrayWord = getArrayWord();
        StringBuilder s = new StringBuilder(" ");
        Random random = new Random(18);
        do {
            int i = random.nextInt((arrayWord.length - 1));
            for (String s1 : Arrays.asList(arrayWord[i], " ")) {
                s.append(s1);
            }
        } while (s.length() <= 100000);
        return s.toString();
    }

    private static String slow(String text) {
        String[] arrayWord = getArrayWord();
        Random random = new Random(18);
        String s = " ";
        do {
            int i = random.nextInt((arrayWord.length - 1));
            s = s.concat(arrayWord[i]);
            s = s.concat(" ");
        } while (s.length() <= 100000);
        return s;
    }

    private static String[] getArrayWord() {
        String[] w = new String[1];
        new StringBuilder(Poem.text);
        Pattern p1 = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m1 = p1.matcher(Poem.text);
        int i = 0;
        while (m1.find()) {
            w[i] = m1.group();
            w = Arrays.copyOf(w, w.length + 1);
            i++;
        }
        return w;
    }
}