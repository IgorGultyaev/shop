package Delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

    public class Emitter {
        private List<Consumer<String>> subscribers = new ArrayList<>();

        public void subscribe(Consumer<String> s) {
            subscribers.add(s);
        }

        public void tracking(String msg) {

//            Tracking tracking = new Tracking();
// TODO Сделать зависимость от  трэкинга
            System.out.println("I say " + msg);
            subscribers.forEach(s -> s.accept(msg));
        }
    }

