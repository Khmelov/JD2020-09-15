package by.it.girovka.jd2_2;
 class Cashier implements Runnable {

     private String name;


     public Cashier(int number){
        name = "Cashier N "+ number+": ";

    }

    @Override
    public void run() {
        System.out.println(this+ " opened");
        while(Dispatcher.planComplete());{
            Buyer buyer = QueueBuyers.extract();
            if(buyer!=null){
                System.out.println(this+" begin to service "+buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.sleep(t);
                System.out.println(this+" finished to service "+buyer);
                synchronized (buyer){
                    buyer.notify();
                    System.out.flush();
                }
            }
                else{
                    Helper.sleep(100);
            }
        }

        System.out.println(this+ " closed");

    }
     @Override
     public String toString() {
         return name;
     }
}
