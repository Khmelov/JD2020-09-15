package by.it.siarheikorbut.jd02_03;

import java.util.HashMap;

public interface IUseBasket extends IBuyer {
    HashMap<String, String> goods = new HashMap<>() {{
        put("2.0 $", "Bananas");
        put("1.45 $", "Milk");
        put("2.30 $", "Grapes");
        put("0.95 $", "Bread");
    }};

    void takeBasket();

    void putGoodsToBasket();
}
