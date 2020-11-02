package by.it.kolesnikov.jd02_06;

public class Runner extends Thread{


    public Runner(String name) {
        super(name);
    }

    @Override
        public void run() {
        Logger.getLogger().log(this.getName());
        }

    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            new Runner("thread "+i+" get logged;").start();
        }



    }




}
