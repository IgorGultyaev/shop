package shop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

    private static final String[] filterMenu = {"Выберите по какому критерию отфильтровать",
            "0 - Выход",
            "1 - По ключевому слову",
            "2 - Цене",
            "3 - Производителю"
    };
    private static final String fileName = "new_data.json";

    private static String readString(String file) {
        String line;
        StringBuilder json = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json.toString().replaceAll("\\s+", "");
    }

    static Map<Integer, Production> jsonToProduction(String json) throws ParseException {

        Map<Integer, Production> productions = new HashMap<>();
        JSONParser jsonParser = new JSONParser();
        JSONArray lang = (JSONArray) jsonParser.parse(json);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        for (Object jsonObj : lang) {

            Production production = gson.fromJson(jsonObj.toString(), Production.class);
//            System.out.println(production.getProductionID());
            productions.put(production.getProductionID(),production);
        }
        return productions;
    }
    private static void printAvailableProducts(Storehouse storehouse) {
        storehouse.printingProducts();
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
                if (choiceInt < listOfChoice.length-1) {
                    carrent = true;
                }
            } else {
                carrent = false;
            }
        } while (!carrent);
        return choiceInt;
    }

    public static void main(String[] args) throws ProductionTypeException, FiltersParamException, ParseException {

        boolean exit = true;

        Storehouse storehouse = Storehouse.getStorehouse();
        storehouse.addProduction(jsonToProduction(readString(fileName)));

        boolean submenu = false;
        int choice = 0;
        while (exit) {
            Scanner scanner = new Scanner(System.in);
            if (!submenu) {choice = choice(scanner, mainMenu);}

            switch (choice) {
                case 0:
                    exit = false;
                    break;
                case 1:
                    printAvailableProducts(storehouse);
                    break;
                case 2:
                    choice = choice(scanner, filterMenu);
                    choice = choice+20;
                    submenu = true;
                    break;
                case 3:
                    System.out.println("dededed");

                    break;
                case 4:

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
