package by.it.hutnik.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en","UK"));
        ResourceBundle res = ResourceBundle.getBundle("by.it.hutnik.jd02_05.lang.localize");
        System.out.println(res.getString("message.welcome"));
        System.out.println(res.getString("message.question"));
        System.out.println(res.getString("message.firstName"));
        System.out.println(res.getString("message.lastName"));
    }
}
