package by.it.hutnik.jd02_02;



import java.util.ArrayList;
import java.util.List;

class Market {

      public static void main(String[] args) {
        System.out.println("Магазин открыт");
        int number = 0;
        List<Thread> threads = new ArrayList<>();
          for (int i = 1; i <= 2; i++) {
              Cassir cassir = new Cassir(i);
              Thread thread = new Thread(cassir);
              threads.add(thread);
              thread.start();

          }


          while (Supervisor.marketOpen()){
            int countBuyer = Helper.getRandom(2);
            for (int i = 0; i < countBuyer; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                threads.add(buyer);
                Supervisor.BUYERS_IN_SHOP++;
            }
            Helper.vremyaStop(1000);
        }
        for (Thread b: threads){
            try {
                b.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Магазин закрыт");
    }
}

