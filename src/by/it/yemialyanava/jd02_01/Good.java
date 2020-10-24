package by.it.yemialyanava.jd02_01;

import java.util.*;

class Good {

    private static Map<String, Double> goods = new HashMap<>();
    static {
        goods.put("Milk", 1.5);
        goods.put("Carrot", 1.2);
        goods.put("Bread", 1.5);
        goods.put("Banana", 3.4);
        goods.put("Cream", 0.9);
        goods.put("Apple", 1.0);
        goods.put("Egg", 1.4);
        goods.put("Garlic", 0.6);
        goods.put("Onion", 0.7);
        goods.put("Dry Water", 2.1);
        goods.put("Cogniac!", 53.0);
    }

    public static Map<String, Double> getGoods(){
        return goods;
    }
}

