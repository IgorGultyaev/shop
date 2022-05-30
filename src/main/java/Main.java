import shop.Production;
import shop.ProductionTypeException;
import shop.Storehouse;

import java.util.Scanner;

public class Main {

    private static final String[] productType = {"Смартфоны", "Ноутбуки", "Телевизоры",
            "Холодильники и морозильные камеры", "Стиральные машины", "Наушники", "Пылесосы",
            "Кондиционеры", "Планшеты", "Миксеры и блендеры"};

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
                if (choiceInt < listOfChoice.length) {
                    carrent = true;
                }
            } else {
                carrent = false;
            }
        } while (!carrent);
        return choiceInt;
    }


    public static void main(String[] args) throws ProductionTypeException {
        Scanner scanner = new Scanner(System.in);
        int choice = choice(scanner, mainMenu);
        System.out.println(choice);

        Storehouse storehouse = Storehouse.getStorehouse();
        storehouse.addProduction(new Production("Аудио", 12.4, "телевизор", 2));
//        Storehouse storehouse = Storehouse.addProduction(new Production("Аудио", 12.4, "телевизор", 2));
//        Storehouse storehouse1 = Storehouse.addProduction(new Production("Аудио", 12.4, "телевизор", 2));
//        Storehouse storehouse2 = Storehouse.addProduction(new Production("Аудио", 12.4, "телевизор", 2));
//        Storehouse storehouse3 = Storehouse.addProduction(new Production("Аудио", 12.4, "телевизор", 2));
//        Storehouse storehouse4 = Storehouse.addProduction(new Production("Магнитофон", 12.4, "телевизор", 2));


        System.out.println(storehouse);
//        storehouse.printStorehouse();

//        storehouse.printStorehouse();


//        String productionType, double productionPrice, String productionName, int number
    }
}
