package by.it.frolova.testCalc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Lang {
    INSTANCE;
    private Locale locale;
    private static final String BASE_NAME = "by.it.frolova.testCalc.resources.error";
    private ResourceBundle resourceBundle;

    Lang() {
        locale = Locale.getDefault();
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }
}
