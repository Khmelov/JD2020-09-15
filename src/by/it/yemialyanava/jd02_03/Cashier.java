package by.it.yemialyanava.jd02_03;

import java.util.*;

public class Cashier implements Runnable {
    private String name;
    private int number;
    public static Object pause = new Object();
    public static Object monitorForPrint = new Object();
    StringBuilder tabulation = null;

    public Cashier(int number) {
        this.number = number;
        this.tabulation = getTabulation(number);
        this.name = "Cashier № " + number;
    }

    StringBuilder getTabulation(int number) {
        StringBuilder result = new StringBuilder();
        if (number > 1) {
            for (int i = 1; i < number; i++) {
                result.append("\t\t\t\t|");
            }
        }
        return result;
    }

    @Override
    public void run() {
        System.out.printf("%s opened\n", this);
        while (!Supervisor.marketIsClosed()) {
            Buyer buyer;
            if (QueueBuyers.countBuyerInQueuePensioneer() != 0) {
                buyer = QueueBuyers.extractPensioneer();
            } else {
                buyer = QueueBuyers.extract();
            }
            if (Objects.nonNull(buyer)) {
                System.out.printf("%s started service for %s", this, buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.timeout(t);
                printToConsole(buyer);
                System.out.println(this + "  serviced " + buyer + "\n");
                System.out.printf("%s finished service for %s\n", this, buyer);
                synchronized (buyer) {
                    buyer.setWaiting(false);
                    buyer.notify();
                }
            } else {
                synchronized (pause) {
                    Supervisor.cashierStopWork();
                    try {
                        Cashier.pause.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Supervisor.cashierWorkNow();
            }
        }
        System.out.printf("%s closed\n", this);
    }

    private void printToConsole(Buyer buyer) {
        synchronized (monitorForPrint) {
            Map<String, Double> buyerGoods = buyer.getMyGoods();
            double totalSumma = 0;

            StringBuilder bill = new StringBuilder();
            bill.append(tabulation.toString()).append(name).append("\n");
            for (Map.Entry<String, Double> element : buyerGoods.entrySet()) {
                String goodName = element.getKey();
                Double goodPrice = element.getValue();
                totalSumma += goodPrice;
                bill.append(tabulation.toString()).append(goodName).append(" ").append(goodPrice).append("\n");
            }
            Supervisor.setTotalMoneyForAllDay(totalSumma);
            int commonBuyersInTwoQueue = QueueBuyers.countBuyerInQueue() + QueueBuyers.countBuyerInQueuePensioneer();
            bill.append(tabulation.toString()).append("total sum: ").append(totalSumma);
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s\n", bill.toString());
            System.out.printf("%100d men %-8.2f total\n", commonBuyersInTwoQueue, Supervisor.getTotalMoneyForAllDay());
            System.out.println("-----------------------------------------------------------------------------------------------------------");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
