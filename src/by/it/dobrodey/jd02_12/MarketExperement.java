package by.it.dobrodey.jd02_12;




import java.util.ArrayList;
import java.util.List;

public class MarketExperement {

    public static final int TIMEOPENMARKET = 120;




    public static void main(String[] args) {
        int buyerNumber=0;
        List<Buyer> buyerList = new ArrayList<>();
        int second;
        System.out.println("Market opened");


        for (int i = 0; i < 10; i++) {
           Buyer buyer = new Buyer(++buyerNumber);
            if (buyerNumber % 4 == 0) {
                buyer.setPriority(3);
            }
            buyer.start();
            buyerList.add(buyer);
        }
        for ( second = 0; second < TIMEOPENMARKET; second++) {
            int count = funchionCount(second);
            System.out.printf("In %d second in market %d people\n", second, Supervisor.getBuyer());
            if (count > Supervisor.getBuyer() ) {
                for (int i = 0; i < count - Supervisor.getBuyer(); i++) {
                    Buyer buyer = new Buyer(++buyerNumber);
                    if (buyerNumber % 4 == 0) {
                        buyer.setPriority(3);
                    }
                    buyer.start();
                    buyerList.add(buyer);
                }

                Helper.timeout(1000);
            } else Thread.yield();
        }

        for (Buyer buyerl : buyerList) {
            try {
                buyerl.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        FileReadAndWrite.printInFile(FileReadAndWrite.FILENAME, Choose.goodsBuyerMap);
        System.out.printf("In %d second in market %d people\n", second, Supervisor.getBuyer());
        System.out.println("Marked close");

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
