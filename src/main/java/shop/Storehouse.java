package shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storehouse {
    private static Map<String, ProductionType> productions;

//TODO Все решил, работаем только со складом, добавляем туда пока что только продукты

    private Storehouse() {}


    public static void addProductionType(ProductionType production) {
        if (productions == null) {
            productions = new HashMap<>();
            productions.put(ProductionType.getTypeName(), production);
        } else productions.put(ProductionType.getTypeName(), production);

    }

    //TODO добавление нового продукта на склад полное реализовано
    public static void addProduction(Production production) throws ProductionTypeException {
        List<Production> list = new ArrayList<>();
        list.add(production);
        if (productions == null) {
            productions = new HashMap<>();
            productions.put(production.getProductionName(),(new ProductionType(list)));
        } else if (productions.containsKey(production.getProductionName())){
                productions.get(production.getProductionName()).addProductionTypeList(list);
            }
        }

        //TODO доделать возвращение ссылки на объект
public String containsProductionName(String productionName){
        if (productions.containsKey(productionName)){
            return
        }

        return null;
}

    public static Map<String, ProductionType> getProductions() {
        return productions;
    }
}
