package shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storehouse {
    private static Map<String, ProductionType> productions;



    private Storehouse() {
    }
    public static Map<String, ProductionType> add(ProductionType production) {
        if (productions == null) {
            productions = new HashMap<>();
            productions.put(ProductionType.getTypeName(), production);
        } else productions.put(ProductionType.getTypeName(), production);
        return productions;
    }
    public static Map<String, ProductionType> add(Production production) throws ProductionTypeException {
        List<Production> list = new ArrayList<Production>();
        list.add(production);
        if (productions == null) {
            productions = new HashMap<>();
            productions.put(production.getProductionName(),(ProductionType.addProductionTypeList(list)));
        } else productions.put(production.getProductionName(),(ProductionType.addProductionTypeList(list)));
        return productions;
    }




//    public static Map<String, ProductionType> add(List<ProductionType> productions) {
//        if (productions == null) {
//            productions = new HashMap<>();
//            productions.put(ProductionType.getTypeName(), productions);
//        } else productions.put(ProductionType.getTypeName(), productions);
//        return productions;
//    }


    public static Map<String, ProductionType> getProductions() {
        return productions;
    }
}
