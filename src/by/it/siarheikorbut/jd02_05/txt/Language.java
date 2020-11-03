package by.it.siarheikorbut.jd02_05.txt;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    RB;
    private static final String KEYWORDS = "by.it.siarheikorbut.jd02_05.resources.keywords";
    private ResourceBundle resourceBundle;

    Language() {
        setLocale(new Locale("en", "UK"));
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(KEYWORDS, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}