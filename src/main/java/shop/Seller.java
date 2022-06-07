package shop;


public class Seller implements Transaction {
    static Seller seller;
    double many;

    public Seller() {

    }

    public static Seller getSeller() {
        if (seller == null) {
            return new Seller();
        } else return seller;
    }

    @Override
    public void execute(Cart cart, boolean thereOrBack) {
        if (thereOrBack) {
            many = many + cart.getPrice();
            System.out.println(many + " Денег у продавца");

        } else {
            many = many - cart.getPrice();
            System.out.println(many + " Денег у продавца");
        }
    }

    public void refute(String msg) {
        System.out.println("Сообщение у продавца " + msg);
    }

}
