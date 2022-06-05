package Delivery;

import java.util.LinkedList;

public class Tracking {
    public interface command {
        void execute();
    }
    public Tracking() {
        LinkedList<command> commands = new LinkedList<>();
        commands.add(() -> System.out.println("Точка 1"));
        commands.add(() -> System.out.println("ТОчка 2"));
        commands.add(() -> System.out.println("ТОчка 3"));
        System.out.println("Executing in reverse!");
        commands.descendingIterator().forEachRemaining(command::execute);
        commands.iterator().forEachRemaining(command::execute);
    }



}
