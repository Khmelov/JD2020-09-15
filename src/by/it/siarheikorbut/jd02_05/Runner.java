package by.it.siarheikorbut.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Language resource = Language.INSTANCE;
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            resource.setLocale(locale);
        } else resource.setLocale(new Locale("en", "UK"));
        Scanner sc = new Scanner(System.in);
        Locale locale = new Locale("en", "UK");
        for (; ; ) {
            String expression = sc.nextLine();
            if (expression.equals("ru")) {
                locale = new Locale("ru", "RU");
                resource.setLocale(locale);
            }
            if (expression.equals("be")) {
                locale = new Locale("be", "BY");
                resource.setLocale(locale);
            }
            if (expression.equals("en")) {
                locale = new Locale("en", "UK");
                resource.setLocale(locale);
            }
            if (expression.equals("end")) {
                break;
            }

            System.out.println(resource.get(Message.WELCOME));
            System.out.println(resource.get(Message.QUESTION));
            System.out.println(resource.get(User.FIRST_NAME));
            System.out.println(resource.get(User.LAST_NAME));

            Date date = new Date();
            DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, locale);
            System.out.println(df.format(date));
        }
    }
}