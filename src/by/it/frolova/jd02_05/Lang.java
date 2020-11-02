package by.it.frolova.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Lang {
    INSTANCE;
    private Locale locale;
    private static final String LOCALIZE = "by.it.frolova.jd02_05.resources.localize";
    private ResourceBundle resourceBundle;

    Lang() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(LOCALIZE, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
