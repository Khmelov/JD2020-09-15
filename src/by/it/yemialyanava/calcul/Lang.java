package by.it.yemialyanava.calcul;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Lang {
    RB("be"),
    UK("en"),
    RU("ru");
    private static final String MESSAGES ="by.it.yemialyanava.calcul.resourses.messages";

    private Locale locale;
    private ResourceBundle resourceBundle;

    Lang(String strlocale){
        Locale locale = null;
        switch (strlocale) {
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
        resourceBundle = ResourceBundle.getBundle(MESSAGES, locale);
    }
    public String get(String key){
        return resourceBundle.getString(key);
    }
}
