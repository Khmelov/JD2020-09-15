package by.it.sheremet.jd02_05;

import java.util.Locale;

public class Runner {
        public static void main(String[] args) {
            Lang manager = Lang.RB;
            if (args.length==2){
                Locale locale = new Locale(args[0], args[1]);
                manager.setLocale(locale);
            } else {
                manager.setLocale(Locale.ENGLISH);
            }
            System.out.println(manager.get(Message.WELCOME));
            System.out.println(manager.get(Message.QUESTION));
            System.out.println(manager.get(User.FIRST_NAME));
            System.out.println(manager.get(User.LAST_NAME));
        }

    }

