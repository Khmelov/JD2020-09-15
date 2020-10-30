package by.it.fedorinhyk.jd02_05;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResMan res = ResMan.INSTANCE;
        Calendar calendar=Calendar.getInstance();
        Date moment=calendar.getTime();
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            res.setLocale(locale);
        } else {
            res.setLocale(Locale.ENGLISH);
        }
        System.out.println(res.get(Message.HELLO));
        System.out.println(res.get(Message.QUESTION));
        System.out.println(res.get(User.FIRST_NAME));
        System.out.println(res.get(User.LAST_NAME));
        System.out.println(res.get(data.DATA) + " " + moment);
        for (; ; ) {
            String lang = sc.nextLine();
            if (lang.equals("ru")) {
                DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("RU"));
                String s = df.format(new Date());
                System.out.println("Текущая дата" + " " + s); continue;
            }
            if (lang.equals("en")) {
                DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("EN"));
                String s = df.format(new Date());
                System.out.println("The current date" + " " + s); continue;
            }
            if (lang.equals("be")) {
                DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("BE"));
                String s = df.format(new Date());
                System.out.println("Сёняшнее чысло" + " " + s);
            }
            else if (lang.equals("end")){
                break;
            }
        }
    }
}
