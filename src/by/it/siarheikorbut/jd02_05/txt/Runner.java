package by.it.siarheikorbut.jd02_05.txt;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        Language manager = Language.RB;
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        }
        System.out.println(manager.get(IMessage.WELCOME));
        System.out.println(manager.get(IUser.FIRST_NAME));
        System.out.println(manager.get(IUser.LAST_NAME));
        System.out.println(manager.get(IMessage.QUESTION));
    }
}