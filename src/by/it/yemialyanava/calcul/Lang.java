package by.it.yemialyanava.calcul;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public enum Lang {
    RB("be"),
    UK("en"),
    RU("ru");
    private static final String MESSAGES ="by.it.yemialyanava.calcul.resourses.messages";

    private Locale locale;
    private ResourceBundle resourceBundle;
    private DateTimeFormatter formatter;


    Lang(String strlocale){
        Locale locale = null;
        switch (strlocale) {
            case "ru":
                locale = new Locale("ru", "RU");
                formatter = DateTimeFormatter.ofPattern("DD.MM.YYYY hh:mm:ss ");
                break;
            case "be":
                locale = new Locale("be", "BY");
                formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss ");
                break;
            case "en":
                locale = new Locale("en", "UK");
                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss ");
                break;
        }
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(MESSAGES, locale);
    }

    public String getCurrentDate(){

        return LocalDateTime.now().format(formatter);
    }



    public String get(String key){
        return resourceBundle.getString(key);
    }
}
