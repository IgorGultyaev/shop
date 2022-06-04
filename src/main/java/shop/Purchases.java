package shop;

import java.util.LinkedList;

public class Purchases {

    public interface command {
        void execute();
    }
    public Purchases(Cart cart) {
        LinkedList<Tracking.command> commands = new LinkedList<>();

        commands.add(() -> cart.getUser().execute(cart));
        commands.add(() -> Storehouse.getStorehouse().execute(cart));
        commands.add(() -> Seller.getSeller().execute(cart));

        commands.descendingIterator().forEachRemaining(Tracking.command::execute);
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
