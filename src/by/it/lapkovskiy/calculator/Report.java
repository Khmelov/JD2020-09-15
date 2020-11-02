package by.it.lapkovskiy.calculator;

import java.io.File;

public class Report {
    String name;
    String startTime;
    String endTime;
    public StringBuilder operations = new StringBuilder();

    public void addMessage(String line){
        operations.append(line+"\n");
    }
    public void EndReport(){
        Logger logger = Logger.GET;

        String filename = name+" "+startTime+".txt";
        filename = filename.replace(':', ' ');

        logger.log(name,filename);
        logger.log("Start Time:"+startTime,filename);
        logger.log("End Time:"+endTime,filename);
        logger.log(operations.toString(),filename);
    }
}
