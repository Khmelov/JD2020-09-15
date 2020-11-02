package by.it.siarheikorbut.jd02_06;

public class Runner {
    static class Th extends Thread {

        public Th(String line) {
            super(line);
        }

        @Override
        public void run() {
            Logger logger = Logger.getInstance();
            logger.log(getName());
        }
    }

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("start\n-----");
        for (int i = 0; i < 10; i++) {
            new Th("th" + i).start();
        }
    }
}