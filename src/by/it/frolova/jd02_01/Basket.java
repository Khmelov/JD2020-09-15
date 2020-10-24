package by.it.frolova.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Good> goods;

    public Basket() {
        this.goods = new ArrayList<>();
    }

    void add(Good good) {
        goods.add(good);
    }

}
