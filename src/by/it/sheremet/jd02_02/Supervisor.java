package by.it.sheremet.jd02_02;


 class Supervisor {
    private Supervisor(){
    }

   static volatile int buyersEnterToMarket = 0;

   static volatile int buyersLeaveToMarket = 0;

   private static final int buyerTotal = 100;

   static synchronized void addBuyer(){
       buyersEnterToMarket++;

   }

   static void leaveBuyer(){
       synchronized (Supervisor.class){
           buyersLeaveToMarket++;
       }

   }

   static boolean marketIsOpen(){
       return buyersEnterToMarket != buyerTotal;
   }

    static boolean marketIsClose(){
       return buyersLeaveToMarket == buyerTotal;
    }

}








