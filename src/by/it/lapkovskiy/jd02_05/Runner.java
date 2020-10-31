package by.it.lapkovskiy.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;
        if(args.length==2){
            Locale locale = new Locale(args[0],args[1]);
            resMan.setLocale(locale);
        }
        System.out.println(resMan.get(Message.hello));
        System.out.println(resMan.get(User.firstName));
        System.out.println(resMan.get(User.lastName));
        System.out.println(resMan.get(Message.question));
    }
}
