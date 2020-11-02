package by.it.dobrodey.jd02_06;

public class Runner {

    static class Th extends Thread{

        public Th(String name) {
            super(name);
        }

        @Override
        public void run() {
            Logger1.getLogger().log(this.getName());
        }
    }

    public static void main(String[] args) {
        Logger1 logger = Logger1.getLogger();
        logger.log("one,two,three");
//        for (int i = 1; i < 20; i++) {
//            new Th("Thread"+i).start();
//        }
         Logger2 loger2 = Logger2.GET;
         loger2.log("!!!one,two,three!!!");
    }




}
