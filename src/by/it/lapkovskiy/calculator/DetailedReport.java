package by.it.lapkovskiy.calculator;

import java.sql.Time;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DetailedReport {

    static String getOperation(String line){
            return ConsoleRunner.rasMan.get(Message.error) +": "+line;
    }
    static String getTime(){
            return (DateFormat.getDateInstance(DateFormat.LONG,ConsoleRunner.locale)
                    .format(new Time(new Date().getTime()))) +
                    LocalDateTime.now().getHour()+":"+
                    LocalDateTime.now().getMinute()+":"+
                    LocalDateTime.now().getSecond();
    }
    static String getName(){
            return "Detailed Report";
    }
}
