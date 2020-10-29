package by.it.fedorinhyk.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan res = ResMan.INSTANCE;
        if (args.length==2){
            Locale locale = new Locale(args[0], args[1]);
            res.setLocale(locale);
        }
        else {
            res.setLocale(Locale.ENGLISH);
        }
        System.out.println(res.get(Message.HELLO));
        System.out.println(res.get(Message.QUESTION));
        System.out.println(res.get(User.FIRST_NAME));
        System.out.println(res.get(User.LAST_NAME));
    }
}
