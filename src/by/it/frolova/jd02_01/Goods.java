package by.it.frolova.jd02_01;

import java.util.HashMap;
import java.util.Map;


public class Goods {
    private final Map<Good, Double> goods = new HashMap<>();

    public Map<Good, Double> getGoods() {
        goods.put(new Good("bread"), 3.05);
        goods.put(new Good("milk"), 2.25);
        goods.put(new Good("salt"), 0.25);
        goods.put(new Good("cheese"), 10.25);
        goods.put(new Good("coffee"), 20.07);
        return goods;
    }
}
