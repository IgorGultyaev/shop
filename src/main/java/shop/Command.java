package shop;

import java.util.LinkedList;

public class Command {
    public interface command {
        void execute();
    }
    public Command() {
        LinkedList<command> commands = new LinkedList<>();
        commands.add(() -> System.out.println("Action 1"));
        commands.add(() -> System.out.println("Action 2"));
        commands.add(() -> System.out.println("Action 3"));
        System.out.println("Executing in reverse!");
        //commands.descendingIterator().forEachRemaining(command::execute);
    }

}
