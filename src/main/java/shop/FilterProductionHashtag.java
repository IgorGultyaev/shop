package shop;

import java.util.Map;
import java.util.stream.Collectors;

public interface FilterProductionHashtag {
    default Map<Integer, Production> filterProductionHashtag(Map<Integer, Production> productions, String hashtag) {
        return productions.entrySet().stream()
                .filter(x -> (x.getValue().getManufacturer()
                        + x.getValue().getProductionType()
                        + x.getValue().getDescription())
                        .contains(hashtag))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }
}
