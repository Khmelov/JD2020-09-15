package by.it.dobrodey.jd02_05;



import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
/*
 Вариант B. Доработайте программу так, чтобы:
  Выводилась текущая дата в том же языковом стандарте, что и приветствие.
   Язык можно было переключать с клавиатуры командами ru be en.
  Ресурсы нужно создать сначала как текстовые файлы в формате utf-8 и получить из них файлы
.properties утилитой native2ascii. Приведите использованные при этом команды в текстовом файле команды.txt.

 */

public class Runner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ведите ru/be/en");

        Lang manager = Lang.INSTANCE;
        Locale locale;
        String language = sc.nextLine();
        if(Lang.lang.containsKey(language)){ locale = new Locale(language, Lang.lang.get(language));}
        else{ locale=Locale.getDefault();}

        manager.setLocale(locale);

        Date d = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, locale);
        System.out.printf(manager.get(Message.DATA),df.format(d).toString());

        System.out.println(manager.get(Language.OPERASSION));
        System.out.println(manager.get(Message.WELCOME));
        System.out.println(manager.get(Message.QUESTION));
        System.out.println(manager.get(User.FIRST_NAME));
        System.out.println(manager.get(User.LAST_NAME));
    }
}
