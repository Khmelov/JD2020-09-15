package by.it.frolova.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Lang manager = Lang.INSTANCE;
        Scanner sc = new Scanner(System.in);
        Date date = new Date();
        Locale locale = new Locale("en", "US");
        if (args.length == 2) {
            locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
            print(manager);
            printDate(date, locale);
        } else {
            for (; ; ) {
                String inputLocale = sc.nextLine();
                if (inputLocale.equals("end")) {
                    break;
                } else if (inputLocale.equals("en")) {
                    locale = new Locale("en", "US");
                    manager.setLocale(locale);
                } else if (inputLocale.equals("be")) {
                    locale = new Locale("be", "BY");
                    manager.setLocale(locale);
                } else if (inputLocale.equals("ru")) {
                    locale = new Locale("ru", "RU");
                    manager.setLocale(locale);
                } else {
                    manager.setLocale(Locale.ENGLISH);
                }

                print(manager);
                printDate(date, locale);
            }
        }
    }

    private static void printDate(Date date, Locale locale) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        System.out.println(dateFormat.format(date));
    }

    private static void print(Lang manager) {
        System.out.printf("%s\n%s\n%s\n%s\n", manager.get(Greeting.HELLO)
                , manager.get(Greeting.QUESTION), manager.get(User.FIRST_NAME)
                , manager.get(User.LAST_NAME));
    }
}
