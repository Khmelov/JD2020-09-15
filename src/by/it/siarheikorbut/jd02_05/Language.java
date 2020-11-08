package by.it.siarheikorbut.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    INSTANCE;
    public static final String BASE_NAME = "by.it.siarheikorbut.jd02_05.resources.keywords";
    private ResourceBundle bundle;

    Language() {
        Locale locale = Locale.getDefault();
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(
                BASE_NAME, locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}