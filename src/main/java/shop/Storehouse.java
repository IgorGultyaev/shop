package shop;

import java.util.HashMap;
import java.util.Map;

public class Storehouse implements PrintProduction, Transaction{
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

    public boolean downloadProduction(Map<Integer, Production> productions){
        this.productions = productions;

        return true;
    }

    public void addProduction(Integer id,String productionType,
                              String manufacturer,
                              String description,
                              int number,
                              double productionPrice) throws ProductionTypeException {

        if (productions.containsKey(id)){
            throw new ProductionTypeException("Поле productionID не должно повторяться");
        }else {
            productions.put(id, new Production(id,
                    productionType,manufacturer,
                    description,number,productionPrice));
        }
    }

//    public Map<Integer, Production> filterProduction(String hashtag) {
//
//        return  this.productions.entrySet().stream()
//                .filter(x -> hashtag.equals(x.getValue().getManufacturer()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//
//    }

//    public Map<Integer, Production> filterProductionHashtag(String hashtag) {
//
//        return  this.productions.entrySet().stream()
//                .filter(x -> (x.getValue().getManufacturer()
//                        + x.getValue().getProductionType()
//                        + x.getValue().getDescription())
//                        .contains(hashtag) )
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

//    }
//    public Map<Integer, Production> filterProductionByPrice(double min, double max) {
//        return  this.productions.entrySet().stream()
//                .filter(x -> x.getValue().getProductionPrice() > min && x.getValue().getProductionPrice() < max)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//    }



    public Production getProduction(Integer num) throws ProductionTypeException {
        if (productions.containsKey(num)){
            return productions.get(num);
        } else {
            throw new ProductionTypeException("Товара с таким номером на складе нет");
        }
    }

    @Override
    public void execute(Cart cart,boolean thereOrBack) {
        if (thereOrBack){
            cart.getPurchases().forEach((key, value) -> this.productions.remove(key,value));
        } else {
            this.productions.putAll(cart.getPurchases());
            System.out.println(cart.getPurchases());
            System.out.println(" продукты добавлены на склад");
        }

    }

    public Map<Integer, Production> getProductions() {
        return new HashMap<>(productions);
    }

}

