package visitor;

import Bank.BankAccount;
import shop.Cart;
import shop.PrintProduction;
import shop.Production;
import shop.Transaction;

import java.util.HashMap;
import java.util.Map;

public class User extends Visitor implements Payment, Transaction, PrintProduction, BankAccount {
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


    public String getUserName(){
        return userName;
    }
    public void setMany(double many) {
        this.many = many;
    }

    @Override
    public void execute(Cart cart) {
        purchases.putAll(cart.getPurchases());
        many = many - cart.getPrice();
    }

    public Map<Integer, Production> getPurchases() {
        return new HashMap<>(purchases);

    }

    public void refute(String msg) {
        System.out.println("Сообщение у покупателя " + msg +
                " доставлено");
    }

}
