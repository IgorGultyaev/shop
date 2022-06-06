package Delivery;

import shop.Production;

import java.util.LinkedList;
import java.util.Map;

public class Tracking {
    public interface command {
        void execute();
    }
    public Tracking(Emitter emitter, Map<Integer, Production> purchases) {

        StringBuilder msg = new StringBuilder();
            purchases.forEach((key, value) ->
                    msg.append(value.getProductionType()).append(" ").append(value.getManufacturer()).append(" , "));


        LinkedList<command> commands = new LinkedList<>();
        commands.add(() -> emitter.tracking( "Покупки " + msg.toString() + " покинули сортировочный центр"));
        commands.add(() -> emitter.tracking("Покупки " + msg.toString() + " прошли таможню"));
        commands.add(() -> emitter.tracking("Покупки " + msg.toString() + " прибыли в пункт назначения"));

//        commands.descendingIterator().forEachRemaining(command::execute);
        commands.iterator().forEachRemaining(command::execute);
    }



}
