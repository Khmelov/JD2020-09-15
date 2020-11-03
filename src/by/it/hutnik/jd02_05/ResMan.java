package by.it.hutnik.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    public static final String ID = "by.it.hutnik.jd02_05.lang.localize";
    private ResourceBundle resourceBundle;
    private Locale locale;
    private ResMan(){
        locale = Locale.getDefault();
        setLocale(locale);
    }

    private void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(ID, locale);
    }

    public String string (String str) {
        return resourceBundle.getString(str);
    }
}
