package shop;

import Delivery.Tracking;

import java.util.LinkedList;

public class Purchases {

    public Purchases(Cart cart, Storehouse storehouse, boolean thereOrBack) {

        System.out.println(cart.getUser().getUserName()
                + " у Вас " + cart.getUser().getMany() + " Рублей");
        System.out.println("Стоимость покупки " + cart.getPrice() + " Рублей");

        LinkedList<Tracking.command> commands = new LinkedList<>();
        commands.add(() -> cart.getUser().execute(cart, thereOrBack));
        commands.add(() -> storehouse.execute(cart, thereOrBack));
        commands.add(() -> Seller.getSeller().execute(cart, thereOrBack));

        if (thereOrBack) {
            if (cart.getPrice() <= cart.getUser().getMany()) {
                commands.descendingIterator().forEachRemaining(Tracking.command::execute);
                cart.clear();
                System.out.println(" козина: " + cart.getPurchases());
                System.out.println("Отправлены товары для " + cart.getUser().getUserName());
                cart.getUser().printingProducts(cart.getUser().getPurchases());
            } else {
                System.out.println("Этого не достаточно для покупки, пополните счёт");
            }
        } else {
            commands.iterator().forEachRemaining(Tracking.command::execute);
            System.out.println(cart.getUser().getMany() + " Денег у " + cart.getUser().getUserName());
            cart.clear();
        }
    }

}


