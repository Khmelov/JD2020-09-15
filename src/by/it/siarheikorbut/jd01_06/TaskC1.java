package by.it.siarheikorbut.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/184w9bSZcb6EcCcpfp_ff1nl2atlGKnpz/view?usp=sharing">Задание JD01_06</a>
 */

public class TaskC1 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(Poem.text);
        StringBuilder sbEnd = new StringBuilder();
        Pattern patternFindMax = Pattern.compile("\\n");
        Matcher matcherFindMax = patternFindMax.matcher(sb);
        int lengthRowMax = 0;

        //Поиск максимально длинной строки
        lengthRowMax = findLengthRowMax(matcherFindMax, lengthRowMax);
        System.out.println("максимальная длинна строки:" + lengthRowMax);
        String varString = sb.toString();
        String[] arrayStrings = varString.split("\n");

        //Заполнение промежутков между словами пробелами
        getStringWithSpaces(sbEnd, lengthRowMax, arrayStrings);
        System.out.print(sbEnd);
    }

    private static void getStringWithSpaces(StringBuilder sbEnd, int lengthRowMax, String[] arrayStrings) {
        for (int i = 0; i < arrayStrings.length; i++) {
            if (i < arrayStrings.length - 1) {
                if (arrayStrings[i].length() < lengthRowMax - 1) {
                    StringBuilder sbNew = new StringBuilder(arrayStrings[i]);
                    if (i < arrayStrings.length - 1) {
                        sbNew.append("\n");
                    }
                    int pos;
                    Pattern pNew = Pattern.compile("[ ][-а-яА-Я]");
                    Matcher mNew = pNew.matcher(sbNew);
                    while (sbNew.length() < lengthRowMax) {
                        pos = 0;
                        while (mNew.find(pos)) {
                            pos = mNew.end();
                            sbNew.replace(mNew.start(), mNew.end() - 1, "  ");
                            if (sbNew.length() == lengthRowMax) break;
                        }
                    }
                    sbEnd.append(sbNew);
                } else {
                    sbEnd.append(arrayStrings[i]).append("\n");
                }
            }

            if (i == arrayStrings.length - 1) {
                if (arrayStrings[i].length() < lengthRowMax - 1) {
                    StringBuilder sbNew = new StringBuilder(arrayStrings[i]);
                    int pos;
                    Pattern pNew = Pattern.compile("[ ][-а-яА-Я]");
                    Matcher mNew = pNew.matcher(sbNew);
                    while (sbNew.length() < lengthRowMax - 1) {
                        pos = 0;
                        while (mNew.find(pos)) {
                            pos = mNew.end();
                            sbNew.replace(mNew.start(), mNew.end() - 1, "  ");
                            if (sbNew.length() == lengthRowMax) break;
                        }
                    }
                    sbEnd.append(sbNew);
                } else {
                    sbEnd.append(arrayStrings[i]);
                }
            }
        }
    }

    private static int findLengthRowMax(Matcher m2, int lengthRowMax) {
        int pos;
        pos = 0;
        while (m2.find(pos)) {
            int lengthRow = m2.start() - pos + 1;
            if (lengthRow > lengthRowMax) {
                lengthRowMax = lengthRow;
            }
            pos = m2.start() + 1;
        }
        return lengthRowMax;
    }
}