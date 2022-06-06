package shop;

import Delivery.Emitter;
import Delivery.Tracking;
import org.json.simple.parser.ParseException;
import visitor.User;

import java.util.Scanner;

public class Main implements LoadingData {

    private static final String[] cartMenu = {"Введите номер товара, который хотите добавить в корзину", "Ноутбуки", "Телевизоры",
            "Холодильники и морозильные камеры", "Стиральные машины", "Наушники", "Пылесосы",
            "Кондиционеры", "Планшеты", "Миксеры и блендеры"};

    private static final String[] mainMenu = {"Выберите действие",
            "1 - Вывод доступных для покупки товаров",
            "2 - Фильтрация товаров по ключевым словам, ценам, производителям",
            "3 - Составление продуктовой корзины пользователя",
            "4 - Вывести на экран товар, который в корзине",
            "5 - Купить товар, который в корзине",
            "6 - Трекинг заказа в системе доставки",
            "7 - Возврат товара",
            "8 - Трекинг заказа в системе доставки",
            "0 - Выход"};

    private static final String[] filterMenu = {"Выберите по какому критерию отфильтровать",
            "0 - Выход",
            "1 - По ключевому слову",
            "2 - Цене",
            "3 - Производителю"
    };
    private static final String fileName = "new_data.json";

    private static void printAvailableProducts(Storehouse storehouse) {
        storehouse.printingProducts(storehouse.getProductions());
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
                if (choiceInt < listOfChoice.length - 1) {
                    carrent = true;
                }
            } else {
                carrent = false;
            }
        } while (!carrent);
        return choiceInt;
    }

    public static void main(String[] args) throws ProductionTypeException, ParseException {

        Tracking tracking = null;
        Emitter emitter = new Emitter();
        boolean exit = true;
        User user = new User("Игорь", 100_000);
        Seller seller = new Seller();
        Cart cart = new Cart(user);
        ;

        Storehouse storehouse = Storehouse.getStorehouse();
        storehouse.downloadProduction(ParserJsonToProduction
                .jsonToProduction(LoadingData.readString(fileName)));

        boolean submenu = false;
        int choice = 0;
        while (exit) {
            Scanner scanner = new Scanner(System.in);
            if (!submenu) {
                choice = choice(scanner, mainMenu);
            }

            switch (choice) {
                case 0:
                    exit = false;
                    break;
                case 1:
                    printAvailableProducts(storehouse);
                    break;
                case 2:
                    choice = choice(scanner, filterMenu);
                    choice = choice + 20;
                    submenu = true;
                    break;
                case 3:
                    System.out.print("Введите номер товара для добавления в корзину>");
                    String productNumStr = scanner.nextLine();
                    if (strIsNum(productNumStr)) {
                        int productNum = Integer.parseInt(productNumStr);
                        System.out.println("Товары добавленные в корзину:");
                        cart.addPurchases(storehouse.getProduction(productNum));
                        cart.printingProducts(cart.getPurchases());
                        System.out.println(cart.getPrice());
                    }
                    System.out.println("Введённое значение должно быть числовым");

                    break;
                case 4:// печать корзины
                    cart.printingProducts(cart.getPurchases());
                    System.out.println("Итого: " + cart.getPrice());
                    break;
                case 5:// Покупка
                {
                    Purchases purchases = new Purchases(cart, storehouse, true);
                }

                break;

                case 6:// отслеживание посылки
                    emitter.subscribe(user::refute);
                    emitter.subscribe(seller::refute);
                    tracking = new Tracking(emitter, user.getPurchases());
                    tracking.trackingTo(true);
                    break;

                case 7:// Возврат отслеживание посылки
                    if (tracking == null) {
                        System.out.println("У пользователя " + user.getUserName() + " не товаров, которые можно вернуть");
                    } else {
                        tracking.trackingTo(false);
                        cart.backProduction(user.getPurchases());
                        Purchases purchases = new Purchases(cart, storehouse, false);
                    }
//TODO доделать возврат денег продавцу возможно впихнуть его куда нибудь в Purchases

                    break;

                case 20:
                    submenu = false;
                    break;
                case 21:
                    storehouse.filterProductionHashtag("Space").forEach((key, value) -> System.out.println(value));
                    submenu = false;
                    break;
                case 22:
                    storehouse.filterProductionByPrice(10_000, 30_000).forEach((key, value) -> System.out.println(value));
                    submenu = false;
                    break;
                case 23:
                    storehouse.filterProduction("Acer").forEach((key, value) -> System.out.println(value));
                    submenu = false;
                    break;
            }

        }


    }
}
