package shop;

import java.util.Scanner;

public class Main {

    private static final String[] productType = {"Смартфоны", "Ноутбуки", "Телевизоры",
            "Холодильники и морозильные камеры", "Стиральные машины", "Наушники", "Пылесосы",
            "Кондиционеры", "Планшеты", "Миксеры и блендеры"};

    private static final String[] mainMenu = {"Выберите действие",
            "1 - Вывод доступных для покупки товаров",
            "2 - Фильтрация товаров по ключевым словам, ценам, производителям",
            "3 - Составление продуктовой корзины пользователя",
            "4 - Трекинг заказа в системе доставки",
            "5 - Возврат заказа, повторение заказа",
            "6 - Система рейтинга для товаров",
            "7 - Простая рекомендательная система для покупок",
            "0 - Выход"};

    private static void printAvailableProducts(Storehouse storehouse){
        storehouse.printingProducts();
    }

    private static void filter(Storehouse storehouse) throws FiltersParamException {
//        storehouse.filterProduction(storehouse);
        //System.out.println(storehouse.filterProduction(storehouse));

//        storehouse.filterProduction("Смартфон");
//        printAvailableProducts(storehouse);

    }

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


    public static void main(String[] args) throws ProductionTypeException, FiltersParamException {

        boolean exit = true;




        Storehouse storehouse = Storehouse.getStorehouse();



        storehouse.addProduction(1,"Смартфон","Xiaomi","Redmi 9A 32GB Granite Gray",2,8999);
        storehouse.addProduction(2,"Смартфон","Apple","11 64GB Black",2,47999);
        storehouse.addProduction(3,"Смартфон","Honor","50 Lite 6+128GB Space Silver",2,20499);

        storehouse.addProduction(4,"Ноутбук","Acer","Aspire 5 A517-52-33P2",2,54999);
        storehouse.addProduction(5,"Ноутбук","ASUS","R429MA-EK1506W",2,29999);
        storehouse.addProduction(6,"Ноутбук","Honor","MagicBook X 15 i5/8/512 Gray",2,74999);


//
//        storehouse.addProduction(new Production(", 54999, " Aspire 5 A517-52-33P2", 2,4));
//        storehouse.addProduction(new Production("Ноутбук", 29999, "ASUS ", 2,5));
//        storehouse.addProduction(new Production("Ноутбук", , "Honor ", 2,6));
//
//        storehouse.addProduction(new Production("Телевизор", 19999, "Haier 32 Smart TV MX", 2,7));
//        storehouse.addProduction(new Production("Телевизор", 17499, "Hi VHIX-43F169MSY", 2,8));
//        storehouse.addProduction(new Production("Телевизор", 15999, "Novex NWX-32F103TSY Titanium", 2,9));
//
//        storehouse.addProduction(new Production("Холодильник", 51999, "Haier C2F637CWMV", 2,10));
//        storehouse.addProduction(new Production("Холодильник", 29999, "Beko RCSK 335M20 W", 2,11));
//        storehouse.addProduction(new Production("Холодильник", 46999, "LG GA-B509DQXL", 2,12));
//
//        storehouse.addProduction(new Production("Стиральные машины", 41999, "Haier HW70-BP12969A", 2,13));
//        storehouse.addProduction(new Production("Стиральные машины", 32999, "Haier HW60-BP10929A", 2,14));
//        storehouse.addProduction(new Production("Стиральные машины", 38999, "Whirlpool FWSG71083WSV RU", 2,15));

//        storehouse.addProduction(new Production("Наушники", 12.4, "магнитофон", 2));
//        storehouse.addProduction(new Production("Наушники", 12.4, "магнитофон", 2));
//        storehouse.addProduction(new Production("Наушники", 12.4, "магнитофон", 2));
//
//        storehouse.addProduction(new Production("Пылесосы", 12.4, "магнитофон", 2));
//        storehouse.addProduction(new Production("Пылесосы", 12.4, "магнитофон", 2));
//        storehouse.addProduction(new Production("Пылесосы", 12.4, "магнитофон", 2));
//
//        storehouse.addProduction(new Production("Кондиционеры", 12.4, "магнитофон", 2));
//        storehouse.addProduction(new Production("Кондиционеры", 12.4, "магнитофон", 2));
//        storehouse.addProduction(new Production("Кондиционеры", 12.4, "магнитофон", 2));
//
//        storehouse.addProduction(new Production("Планшеты", 12.4, "магнитофон", 2));
//        storehouse.addProduction(new Production("Планшеты", 12.4, "магнитофон", 2));
//        storehouse.addProduction(new Production("Планшеты", 12.4, "магнитофон", 2));
//
//        storehouse.addProduction(new Production("Миксеры и блендеры", 12.4, "магнитофон", 2));
//        storehouse.addProduction(new Production("Миксеры и блендеры", 12.4, "магнитофон", 2));
//        storehouse.addProduction(new Production("Миксеры и блендеры", 12.4, "магнитофон", 2));



        while (exit){
            Scanner scanner = new Scanner(System.in);
            int choice = choice(scanner, mainMenu);

            switch (choice) {
                case 0: exit = false;
                break;
                case 1: printAvailableProducts(storehouse);
                break;
                case 2: storehouse.filterProduction("Acer").forEach((key, value) -> System.out.println(value));
                    break;

                case 3: storehouse.filterProductionHashtag("Space").forEach((key, value) -> System.out.println(value));
                    break;


            }

        }



    }
}
