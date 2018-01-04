import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {
    private Map<String, Purchase> basket = new HashMap<String, Purchase>();

    public ShoppingBasket() {
    }

    public void add(String product, int price) {
        Purchase p = new Purchase(product, 1, price);
        if (basket.containsKey(product)) {
            basket.get(product).increaseAmount();
        } else {
            basket.put(product, p);
        }
    }

    public int price() {
        int price = 0;
        for (Purchase each : basket.values()) {
            price += each.price();
        }
        return price;
    }

    public void print() {
        for (Purchase eachPurchase : basket.values())
            System.out.println(eachPurchase);
    }
}
