package by.it.siarheikorbut.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/184w9bSZcb6EcCcpfp_ff1nl2atlGKnpz/view?usp=sharing">Задание JD01_06</a>
 */

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern p1 = Pattern.compile("[. ]{4}[а-я]");
        Matcher m1 = p1.matcher(sb);

        //Замена троеточия
        replace(sb, m1);
        Pattern p2 = Pattern.compile("[-,:\\na-zA-Z]");
        Matcher m2 = p2.matcher(sb);

        //Замена небуквенных символов
        replaceNotLetterSymbol(sb, m2);
        Pattern p3 = Pattern.compile("[!?]+");
        Matcher m3 = p3.matcher(sb);

        //Замениа символов конца предложения на "."
        replaceEndSentence(sb, m3);
        Pattern p4 = Pattern.compile("[ ]{2,}");
        Matcher m4 = p4.matcher(sb);

        //Замена повтояриющихся пробелов
        replaceSeveralSpaces(sb, m4);
        String varString = sb.toString();

        //Создание массива строк для предложений
        String[] arrayStrings;
        arrayStrings = varString.trim().split("[.]");

        //Обрезание пробелов в начале и конце каждого предложения
        trimSpaces(arrayStrings);

        //Сортировка массива по возрастанию
        arraySort(arrayStrings);
        printArray(arrayStrings);
    }

    private static void printArray(String[] arrayStrings) {
        for (String arrayString : arrayStrings) {
            System.out.println(arrayString);
        }
    }

    private static void trimSpaces(String[] arrayStrings) {
        for (int i = 0; i < arrayStrings.length; i++) {
            arrayStrings[i] = arrayStrings[i].trim();
        }
    }

    private static void arraySort(String[] arrayStrings) {
        int b = arrayStrings.length - 1;
        String buf;
        boolean det;
        do {
            det = false;
            for (int i = 0; i < b; i++) {
                if (arrayStrings[i].length() > arrayStrings[i + 1].length()) {
                    buf = arrayStrings[i + 1];
                    arrayStrings[i + 1] = arrayStrings[i];
                    arrayStrings[i] = buf;
                    det = true;
                }
            }
            b--;
        }
        while (det);
    }

    private static void replaceSeveralSpaces(StringBuilder sb, Matcher m4) {
        int pos = 0;
        while (m4.find(pos)) {
            sb.replace(m4.start(), m4.end(), " ");
            pos = m4.start() + 1;
        }
    }

    private static void replaceEndSentence(StringBuilder sb, Matcher m3) {
        int pos = 0;
        while (m3.find(pos)) {
            sb.replace(m3.start(), m3.end(), ".");
            pos = m3.start() + 1;
        }
    }

    private static void replaceNotLetterSymbol(StringBuilder sb, Matcher matcher) {
        while (matcher.find()) {
            sb.replace(matcher.start(), matcher.end(), " ");
        }
    }

    private static void replace(StringBuilder sb, Matcher m1) {
        while (m1.find()) {
            int start;
            int end;
            start = m1.start();
            end = m1.end() - 1;
            sb.replace(start, end, "\n");
        }
    }
}