package shop;

import visitor.User;

import java.util.HashMap;

public class Cart implements PrintProduction {
    private HashMap<Integer, Production> purchases;
    private User user;
    private double price;
    private Seller seller;

    public Cart(User user, Seller seller) {
        this.user = user;
        purchases = new HashMap<>();
        this.seller = seller;
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

    public void backProduction(HashMap<Integer, Production> purchases) {
        this.purchases.putAll(purchases);
        price = 0;
        purchases.forEach((key, value) -> price = price + value.getProductionPrice());
    }

    public double getPrice() {
        return price;
    }

    public User getUser() {
        return user;
    }

    void clear() {
        this.purchases.clear();
    }

    public Seller getSeller() {
        return seller;
    }
}
