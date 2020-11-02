package by.it.yemialyanava.jd02_05;
/*Выводилась текущая дата в том же языковом стандарте, что и приветствие.
         Язык можно было переключать с клавиатуры командами ru be en.
         Ресурсы нужно создать сначала как текстовые файлы в формате utf-8 и получить
        из них файлы .properties утилитой native2ascii. Приведите использованные при
        этом команды в текстовом файле команды.txt.*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Lang manager = null;
        Scanner scanner = new Scanner(System.in);
        String dateFormat = null;
        while(scanner.hasNext()) {
            String commandLanguage = scanner.next();
            switch (commandLanguage) {
                case "ru":
                    manager = Lang.RU;
                    dateFormat = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    break;
                case "be":
                    manager = Lang.RB;
                    dateFormat = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    break;
                case "en":
                    manager = Lang.UK;
                    dateFormat = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    break;
                default:
                    manager = Lang.UK;
                    dateFormat = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    break;
            }
            System.out.println(manager.get(Message.WELCOME));
            System.out.println(manager.get(Message.QUESTION));
            System.out.println(manager.get(User.FIRST_NAME));
            System.out.println(manager.get(User.LAST_NAME));
            System.out.println(manager.get(Message.DATE) + dateFormat.toString() );

        }
        //в комментарии решение на А

        /*if(args.length==2){
            Locale locale = new Locale(args[0],args[1]);
            manager.setLocale(locale);
        } else{
            manager.setLocale(Locale.ENGLISH);
        }
        System.out.println(manager.get(Message.WELCOME));
        System.out.println(manager.get(Message.QUESTION));
        System.out.println(manager.get(User.FIRST_NAME));
        System.out.println(manager.get(User.LAST_NAME));*/
    }
}
