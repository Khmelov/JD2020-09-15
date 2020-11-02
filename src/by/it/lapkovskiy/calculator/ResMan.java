package by.it.lapkovskiy.calculator;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    public static final String DEFAULT_LANGUAGE = "by.it.lapkovskiy.calculator.res.language";
    private Locale locale;
    private ResourceBundle resourceBundle;

    ResMan(){
        locale = Locale.ROOT;
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
       resourceBundle = ResourceBundle.getBundle(DEFAULT_LANGUAGE,locale);
    }
    public String get(String key){
       return resourceBundle.getString(key);
    }
}
