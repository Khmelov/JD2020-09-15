package by.it.frolova.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (args.length == 2) {
            printAll(args[0], args[1]);
        } else {
            for (; ; ) {
                String inputLocale = sc.nextLine();
                if (inputLocale.equals("end")) {
                    break;
                } else {
                    printAll(inputLocale, null);
                }
            }
        }
    }

    private static void printAll(String language, String country) {
        Lang manager = Lang.INSTANCE;
        Locale locale;
        Date date = new Date();
        if (country == null) {
            if (language.equals("en")) {
                locale = new Locale("en", "US");
            } else if (language.equals("be")) {
                locale = new Locale("be", "BY");
            } else if (language.equals("ru")) {
                locale = new Locale("ru", "RU");
            } else {
                locale = Locale.ENGLISH;
            }
        } else {
            locale = new Locale(language, country);
        }
        manager.setLocale(locale);
        print(manager);
        printDate(date, locale);
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