package Delivery;

import shop.Production;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

    public class Emitter {
        private List<Consumer<String>> subscribers = new ArrayList<>();

        public void subscribe(Consumer<String> s) {
            subscribers.add(s);
        }

        public void tracking(String msg) {

// TODO Сделать зависимость от  трэкинга

//            StringBuilder msg = new StringBuilder();
//            purchases.forEach((key, value) ->
//                    msg.append(value.getProductionType()).append(" ").append(value.getManufacturer()).append(" , "));


//            System.out.println(msg);

//            Tracking tracking = new Tracking();
            subscribers.forEach(s -> s.accept(msg.toString()));
        }
    }

