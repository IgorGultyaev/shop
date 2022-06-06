package shop;

import visitor.User;

import java.util.HashMap;

public class Cart implements PrintProduction {
    private HashMap<Integer, Production> purchases;
    private User user;
    private double price;

    public Cart(User user) {
        this.user = user;
        purchases = new HashMap<>();
    }

    public HashMap<Integer, Production> getPurchases() {
        return new HashMap<>(purchases);
    }

    public boolean addPurchases(Production production) {

        purchases.put(production.getProductionID(), production);
        price = 0;
        purchases.forEach((key, value) -> price = price + value.getProductionPrice());

        return true;
    }

    public double getPrice() {
        return price;
    }

    public User getUser() {
        return user;
    }

    void clear(){
        this.purchases.clear();
    }
}
