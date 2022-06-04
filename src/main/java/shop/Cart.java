package shop;

import visitor.User;

import java.util.HashMap;

public class Cart implements PrintProduction{
    private User user;
    HashMap <String, Production> purchases;

    public HashMap<String, Production> getPurchases() {
        return purchases;
    }

    public Cart(User user) {
        this.user = user;
    }

    @Override
    public void printingProducts() {
        if (purchases!=null) {
            this.purchases.forEach((key, value) -> System.out.println(key + " : " + value));
        } else System.out.println("Корзина пуста");
    }
}
