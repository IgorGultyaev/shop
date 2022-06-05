package shop;

import visitor.Payment;

public class Seller implements Payment, Transaction {
    double many;
    static Seller seller;

    public Seller() {

    }

    @Override
    public void execute(Cart cart) {
      many = many + cart.getPrice();
    }

    public static Seller getSeller() {
        if (seller == null) {
            return new Seller();
        } else return seller;
    }
    public void refute(String msg) {
        System.out.println("Сообщение у продавца " + msg +
                " доставлено");
    }

}
