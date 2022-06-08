package shop;

import java.util.Map;
import java.util.stream.Collectors;

public interface FilterProduction {
    public default Map<Integer, Production> filterProductionManufacturer(Map<Integer, Production> productions, String hashtag) {

        return  productions.entrySet().stream()
                .filter(x -> hashtag.equals(x.getValue().getManufacturer()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
