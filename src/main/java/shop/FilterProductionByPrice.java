package shop;

import java.util.Map;
import java.util.stream.Collectors;

public interface FilterProductionByPrice {
        default Map<Integer, Production> filterProductionByPrice(Map<Integer, Production> productions, double min, double max) {
        return  productions.entrySet().stream()
                .filter(x -> x.getValue().getProductionPrice() > min && x.getValue().getProductionPrice() < max)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
