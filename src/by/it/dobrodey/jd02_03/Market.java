package by.it.dobrodey.jd02_03;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {

    public static final int TIMEOPENMARKET = 120;


    public static void main(String[] args) {
        int buyerNumber = 0;
        int second = 0;
        System.out.println("Market opened");
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }
        threadPool.shutdown();

        for (int i = 0; i < 10; i++) {
            Buyer buyer = new Buyer(++buyerNumber);
            if (buyerNumber % 4 == 0) {
                buyer.setPriority(3);
            }
            buyer.start();
        }
        while (Supervisor.marketIsOpened()) {
            int count = funchionCount(second);
            System.out.printf("In %d second in market %d people\n", second, count);
            if (count > Supervisor.getBuyer()) {

                for (int i = 0; i < count - Supervisor.getBuyer() && Supervisor.marketIsOpened(); i++) {
                    Buyer buyer = new Buyer(++buyerNumber);
                    if (buyerNumber % 4 == 0) {
                        buyer.setPriority(3);
                    }
                    buyer.start();
                }
                Helper.timeout(1000);
                second += 1;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        while (true) {
            try {
                if (threadPool.awaitTermination(10, TimeUnit.DAYS)) break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        FileReadAndWrite.printInFile(FileReadAndWrite.FILENAME, Choose.goodsBuyerMap);
        System.out.printf("In market enter %d people and Leave %d people.\nIn market %d people\n",
                Supervisor.getBuyerEnter(), Supervisor.getBuyerLeaved(), Supervisor.getBuyer());
        System.out.println("Market closed");
    }

    private static int funchionCount(int second) {
        int secondNow = second % 60;
        int count;
        if (secondNow <= 30) {
            count = secondNow + 10;
        } else {
            count = 40 + (30 - secondNow);
        }
        return count;
    }
}
