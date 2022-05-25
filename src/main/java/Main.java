import shop.Production;

import java.util.Scanner;

public class Main {

    private static final String[] mainMenu = {"Выберите действие",
            "1 - Зарегистрироваться",
            "2 - Посмотреть список товаров",
            "3 - Завершить покупку"};

    private static boolean strIsNum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static int choice(Scanner scanner, String[] listOfChoice) {
        boolean carrent = false;
        int choiceInt = 0;
        for (String nameOfChoice : listOfChoice) {
            System.out.println(nameOfChoice);
        }
        String choice;
        do {
            System.out.print("Введите значение тут> ");
            choice = scanner.nextLine();
            if (strIsNum(choice)) {
                choiceInt = Integer.parseInt(choice);
                if (choiceInt < listOfChoice.length){
                    carrent = true;
                }
            } else {
                carrent = false;
            }
        } while (!carrent);
        return choiceInt;
    }

    Production production = new Production();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = choice(scanner, mainMenu);
        System.out.println(choice);




    }
}
