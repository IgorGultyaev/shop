package shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Storehouse {
    private static Storehouse storehouse = null;
    private Map<Integer, Production> productions;



    private Storehouse() {
        this.productions = new HashMap<>();
    }

    public static Storehouse getStorehouse() {
        if (storehouse == null) {
            return new Storehouse();
        } else return storehouse;
    }

    public void addProduction(Integer id,String productionType,
                              String manufacturer,
                              String description,
                              int number,
                              double productionPrice){

        productions.put(id, new Production(id,
                productionType,manufacturer,
                description,number,productionPrice));

    }

    public void printingProducts(){
        if (!productions.containsKey(null)) {
            this.productions.forEach((key, value) -> System.out.println(key + " : " + value));
        } else System.out.println("Список товаров недоступен");
    }

    public Map<Integer, Production> filterProduction(String hashtag) {

        return  this.productions.entrySet().stream()
                .filter(x -> hashtag.equals(x.getValue().getManufacturer()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    public Map<Integer, Production> filterProductionHashtag(String hashtag) {

        return  this.productions.entrySet().stream()
                .filter(x -> (x.getValue().getManufacturer()
                        + x.getValue().getProductionType()
                        + x.getValue().getDescription())
                        .contains(hashtag) )
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

}
