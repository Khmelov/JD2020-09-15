package by.it.lapkovskiy.calculator;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;

public class ShortReport {
    static String getName(){
        return "Short Report";
    }
    static String getTime(){
        return (DateFormat.getDateInstance(DateFormat.LONG,ConsoleRunner.locale)
                .format(new Time(new Date().getTime())));
    }
    static String getOperation(String line){
        String newLine="";
        for (char c:line.toCharArray()) {
            if(c==':')break;
            newLine+=c;
        }
        return ConsoleRunner.rasMan.get(Message.error) +": "+newLine;
    }
}
