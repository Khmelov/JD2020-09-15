package by.it.frolova.jd02_02;

import java.util.*;


public class Goods {
    private static final Map<Good, Double> goods = new HashMap<>() {{
        put(new Good("bread"), 3.05);
        put(new Good("milk"), 2.25);
        put(new Good("salt"), 0.25);
        put(new Good("cheese"), 10.25);
        put(new Good("coffee"), 20.07);
    }};

    private Goods() {
    }

    public static List<Good> getGoods() {
        return new ArrayList<>(goods.keySet());
    }

    public static Double getPrice(Good good) {
        return goods.get(good);
    }
}
