package shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storehouse {
    private static Storehouse storehouse = null;
    private Map<String, ProductionType> productions;

//TODO Все решил, работаем только со складом, добавляем туда пока что только продукты

    private Storehouse() {
        this.productions = new HashMap<>();
    }


    public static void addProductionType(ProductionType production) {
//        if (productions == null) {
//            productions = new HashMap<>();
//            productions.put(ProductionType.getTypeName(), production);
//        } else productions.put(ProductionType.getTypeName(), production);

    }


    public static Storehouse getStorehouse() {
        if (storehouse == null) {
            return new Storehouse();
        } else return storehouse;
    }

    public static Map<String, ProductionType> getProductions() {
        return storehouse.productions;
    }

    //TODO добавление нового продукта на склад полное нихуя не реализовано
    public void addProduction(Production production) throws ProductionTypeException {
        List<Production> list = new ArrayList<>();
        list.add(production);



//        if (storehouse == null) {
//            Storehouse storehouse = new Storehouse(list);
////            storehouse.productions = new HashMap<>();
////            storehouse.productions.put(production.getProductionName(),(new ProductionType(list)));
//        } else if (storehouse.productions.containsKey(production.getProductionName())){
//            storehouse.productions.get(production.getProductionName()).addProductionTypeList(list);
//            }
//        return storehouse;
    }

    //TODO доделать возвращение ссылки на объект
    public String containsProductionName(String productionName) {
        return productions.containsKey(productionName) ? productions.get(productionName).getTypeName() : null;
    }

    public void printStorehouse() {
        productions.forEach((key, value)
                -> System.out.println(key + " : " +
                (productions.getOrDefault(value, value))));
    }


//    public void printMissedCalls(PhoneBook phoneBook) {
//        this.missedCalls.forEach((key, value)
//                -> System.out.println(key + " : " +
//                (phoneBook.containsPhone(value) ? phoneBook.getFIOByNumber(value) : value)));


}
