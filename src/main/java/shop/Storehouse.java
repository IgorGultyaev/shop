package shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storehouse implements Filter{
    private static Storehouse storehouse = null;
    private Map<String, ProductionType> productions;

    private Storehouse() {
        this.productions = new HashMap<>();
    }

    public static Storehouse getStorehouse() {
        if (storehouse == null) {
            return new Storehouse();
        } else return storehouse;
    }

    public void addProduction(Production production)  {

        //TODO при добавлении на склад необходимо сделать проверку уникальности номера

        String productionType = production.getProductionType();
        List<Production> list = new ArrayList<>();
        list.add(production);
        if (productions.containsKey(productionType)){
            productions.get(productionType).getProductions().add(production);
        } else productions.put(production.getProductionType(),(new ProductionType(list)));
    }

    public void printStorehouse() {
        productions.forEach((key, value)
                -> System.out.println(key + " " +
                (productions.getOrDefault(value, value))));
    }

    Map<String, ProductionType> getProductions() {
        return productions;
    }
}
