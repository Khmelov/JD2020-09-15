package by.it.fedorinhyk.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum  ResMan {
    INSTANCE;
    public static final String BASE_NAME = "by.it.fedorinhyk.jd02_05.resources.localize";
    private Locale locale;
    private ResourceBundle bundle;

    ResMan() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        this.locale=locale;
        bundle= ResourceBundle.getBundle(BASE_NAME, locale);

    }
    public String get(String key){
        return bundle.getString(key);
    }
}
