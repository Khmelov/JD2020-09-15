package by.it.dobrodey.calc;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public enum Lang {
    INS;

    private static final String KEYWORDS = "by.it.dobrodey.calc.res.keywords";
    public static final Map<String, String> lang = new HashMap<>();
    static {
        lang.put("en","UK");
        lang.put("be","BY");
        lang.put("ru","RU");

    }
    private Locale locale;
    private ResourceBundle resourceBundle;

    Lang() {
        locale = Locale.getDefault();
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(KEYWORDS, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
