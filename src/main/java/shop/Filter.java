package shop;

public interface Filter{
    void filterHashtag(String...param) throws FiltersParamException;



    void resetFilters();
};
//    default Map<String, ProductionType> filterProduction(Storehouse storehouse){
//
//        Map<String, ProductionType> filteredMap = storehouse.getProductions().entrySet().stream()
//                .filter(x->"Смартфон".equals(x.getKey()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//
//        return filteredMap;
//    }

