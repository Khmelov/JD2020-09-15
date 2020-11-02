package by.it.kolesnikov.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        Language manager = Language.RES;
        if (args.length==2){
            Locale locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        } else {
            manager.setLocale(Locale.UK);
        }
        System.out.println(manager.get(Message.WELCOME));
        System.out.println(manager.get(Message.QUESTION));
        System.out.println(manager.get(User.NAME));
        System.out.println(manager.get(User.SURNAME));
    }
}
