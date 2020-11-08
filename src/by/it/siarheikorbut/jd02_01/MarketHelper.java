package by.it.siarheikorbut.jd02_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class MarketHelper {
    private static final HashMap<String, Integer> priceGood = new HashMap<>();

    void getGoodToPrice() {
        priceGood.put("Bread", 1);
        priceGood.put("Milk", 2);
        priceGood.put("Eggs", 3);
        priceGood.put("Sugar", 4);
    }

    static public Map.Entry<String, Integer> takeOneRandomGood(int number) {
        Set<Map.Entry<String, Integer>> entries = priceGood.entrySet();
        int numberInPrice = 1;
        for (Map.Entry<String, Integer> entry : entries) {
            if (number == numberInPrice) {
                return entry;
            }
            numberInPrice++;
        }
        throw new RuntimeException();
    }

    public MarketHelper() {
        System.out.println("Market have price");
    }

    public static int priceGoodSize() {
        return priceGood.size();
    }
}