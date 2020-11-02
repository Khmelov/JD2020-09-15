package by.it.girovka.jd2_5;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Lang {
    RB;
    private static final String KEYWORDS = "qwerty";

    private ResourceBundle resourceBundle;

    Lang() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(KEYWORDS, locale);

    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}