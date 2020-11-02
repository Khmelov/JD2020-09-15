package by.it.lapkovskiy.jd02_05;

import javafx.scene.input.DataFormat;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException {
        DateFormat df ;

        Scanner sc=new Scanner(System.in);
        ResMan resMan = ResMan.INSTANCE;
        Date date = new Date();

        String loc  = sc.nextLine();

        Locale locale;

        switch (loc){
            case "ru":
                locale  = new Locale("ru","RU");
                break;
            case "be":
                locale  = new Locale("be","BY");
                break;
            default:
                locale = new Locale("en","US");

        }
        df = DateFormat.getDateInstance(DateFormat.LONG, locale);

        resMan.setLocale(locale);

        System.out.println(resMan.get(Message.hello));
        System.out.println(resMan.get(User.firstName));
        System.out.println(resMan.get(User.lastName));
        System.out.println(resMan.get(Message.question));
        System.out.println(df.format(date));
    }
}
