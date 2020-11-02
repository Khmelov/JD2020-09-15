package by.it.arhipova.jd02_06;

public class Logger {
    private static volatile Logger logger;
    private Logger(){

  }

  static Logger getLogger(){
        Logger result = logger;
        if (result == null){
            synchronized (Logger.class){
                result = logger;
                if (result == null) {
                    result = logger = new Logger();
                }

            }
        }
        return result;
  }

  void log(String logtxt){
        
  }
}
