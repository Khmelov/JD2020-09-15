package by.it.frolova.testCalc;

import java.util.Locale;

public class LangRunner {
    public static void printAll(String language) {
        Lang manager = Lang.INSTANCE;
        Locale locale;

            if (language.equals("en")) {
                locale = new Locale("en", "US");
            } else if (language.equals("be")) {
                locale = new Locale("be", "BY");
            } else if (language.equals("ru")) {
                locale = new Locale("ru", "RU");
            } else {
                locale = Locale.ENGLISH;
            }
        manager.setLocale(locale);
    }
}
