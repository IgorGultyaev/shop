package visitor;

import shop.Cart;
import shop.PrintProduction;
import shop.Production;
import shop.Transaction;

import java.util.HashMap;
import java.util.Map;

public class User implements Transaction, PrintProduction {
    private String userName;
    private double many;
    private Map<Integer, Production> purchases;

    public User(String userName, double many) {
        this.userName = userName;
        this.many = many;
        purchases = new HashMap<>();
    }

    public double getMany() {
        many = many;
        return many;
    }

    public void setMany(double many) {
        this.many = many;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public void execute(Cart cart, boolean thereOrBack) {
        if (thereOrBack) {
            purchases.putAll(cart.getPurchases());
            many = many - cart.getPrice();
            System.out.println(many + " Денег у покупателя");
        } else {
            cart.getPurchases().forEach((key, value) -> purchases.remove(key));
            System.out.println(purchases);
            System.out.println("Деньги поступят на счет в течении 30 банковских дней, сохраняйте чек пока не получите деньги");
            many = many + cart.getPrice();
            System.out.println(many + " Денег у покупателя");
        }

    }

    public HashMap<Integer, Production> getPurchases() {
        return new HashMap<>(purchases);

    }

    public void refute(String msg) {
        System.out.println("Сообщение у покупателя " + msg);
    }

}
