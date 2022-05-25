package shop; //склад

import java.util.HashMap;
import java.util.Map;

public class Storehouse {
    private Map<String, ProductionType> productions;

    private Storehouse() {
    }
    public Map<String, ProductionType> add(ProductionType production) {
        if (productions == null) {
            productions = new HashMap<>();
            productions.put(production.getTypeName(), production);
        } else productions.put(production.getTypeName(), production);
        return productions;
    }
}
