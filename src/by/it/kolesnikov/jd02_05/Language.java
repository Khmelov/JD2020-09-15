package by.it.kolesnikov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    RES;
    private static final String KEYWORDS = "by.it.kolesnikov.jd02_05.res.localized";

    private Locale locale;

    private ResourceBundle rb;

    Language() {

        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        this.locale=locale;
        rb = ResourceBundle.getBundle(KEYWORDS, locale);

    }

    public String get(String key){

        return rb.getString(key);
    }


}
