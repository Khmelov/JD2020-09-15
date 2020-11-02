package by.it.yemialyanava.jd02_05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public enum Lang {
    RB("be"),
    UK("en"),
    RU("ru");
    private static final String KEYWORDS ="by.it.yemialyanava.jd02_05.resourses.keywords";

    private Locale locale;
    private ResourceBundle resourceBundle;

    Lang(String strLocale){
        Locale locale = null;
        switch (strLocale) {
            case "ru":
                locale = new Locale("ru", "RU");
                break;
            case "be":
                locale = new Locale("be", "BY");
                break;
            case "en":
                locale = new Locale("en", "UK");
                break;
        }
        setLocale(locale);
    }

    public void setLocale(Locale locale){
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(KEYWORDS, locale);
    }
    public String get(String key){
        return resourceBundle.getString(key);
    }
}
