package Delivery;

import shop.Production;

import java.util.LinkedList;
import java.util.Map;


public class Tracking {

    LinkedList<command> commands = new LinkedList<>();
    private Emitter emitter;
    private Map<Integer, Production> purchases;

    public Tracking(Emitter emitter, Map<Integer, Production> purchases) {

        this.emitter = emitter;
        this.purchases = purchases;

        StringBuilder msg = new StringBuilder();
        purchases.forEach((key, value) ->
                msg.append(value.getProductionType()).append(" ").append(value.getManufacturer()).append(" , "));

        this.commands.add(() -> emitter.tracking("Покупки " + msg.toString() + " покинули сортировочный центр"));
        this.commands.add(() -> emitter.tracking("Покупки " + msg.toString() + " прошли таможню"));
        this.commands.add(() -> emitter.tracking("Покупки " + msg.toString() + " покинули пункт назначения"));
    }

    public void trackingTo(boolean thereOrBack) {

        if (thereOrBack) {
            commands.iterator().forEachRemaining(command::execute);
        } else {
            commands.descendingIterator().forEachRemaining(command::execute);
        }

    }

    public interface command {
        void execute();
    }


}
