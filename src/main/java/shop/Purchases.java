package shop;

import Delivery.Tracking;

import java.util.LinkedList;

public class Purchases {

    public interface command {
        void execute();
    }
    public Purchases(Cart cart,Storehouse storehouse) {

        boolean moneyEnough = false;
        System.out.println(cart.getUser().getUserName()
                + " у Вас " + cart.getUser().getMany() + " Рублей");
        System.out.println("Стоимость покупки " + cart.getPrice() + " Рублей");
        if (cart.getUser().getMany() > cart.getUser().getMany()) {

            System.out.println("Этого не достаточно для покупки, пополните счёт");
            moneyEnough = false;
        } else {
            System.out.println("Этого достаточно для покупки");
            moneyEnough = true;
        }

        if (moneyEnough){
            LinkedList<Tracking.command> commands = new LinkedList<>();
            commands.add(() -> cart.getUser().execute(cart));
            commands.add(() -> storehouse.execute(cart));
            commands.add(() -> Seller.getSeller().execute(cart));

            commands.descendingIterator().forEachRemaining(Tracking.command::execute);
            System.out.println(cart.getUser().getUserName()
                    + " у Вас " + cart.getUser().getMany() + " Рублей");
            cart.clear();
            System.out.println(" козина: " + cart.getPurchases());
            System.out.println("Отправлены товары для " + cart.getUser().getUserName());
            cart.getUser().printingProducts(cart.getUser().getPurchases());
        }


//        commands.iterator().forEachRemaining(Tracking.command::execute);
    }

//    private Transaction userTransaction;
//    private Transaction storehouseTransaction;
//    private Transaction sellerTransaction;
//
//    public Purchases(Cart cart) {
//        this.userTransaction.execute(cart);
////        this.storehouseTransaction = storehouseTransaction;
////        this.sellerTransaction = sellerTransaction;
//    }
//
//    public void userSend(Cart cart) {
//    userTransaction.execute(cart);
//    }
//
////    public void writeFromStorehouse(Cart cart){
////        storehouseTransaction.execute(cart);
////    }
////
////    public void transferMoneyToSeller(Cart cart){
////        sellerTransaction.execute(cart);
//    }


//    Production production;
//    DateTimeFormatter dateTime;
//
//    public Purchases(Production production) {
//        this.production = production;
//        dateTime = time();
//    }
//
//    private DateTimeFormatter time() {
//        return DateTimeFormatter
//                .ofPattern("dd.MM.yy hh:mm:ss");
////                .format(LocalDateTime.now());
//    }
}
