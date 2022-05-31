package shop;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Filter {
    public default Map<String, ProductionType> filterProduction(Storehouse storehouse){
        Production production1 = null;
//        Stream<Production> stream = storehouse.getProductions().entrySet().stream()
//                .filter(x -> );
        Map<String, ProductionType> filteredMap = storehouse.getProductions().entrySet().stream()
                .filter(x->"Смартфон".equals(x.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

//        Stream <ProductionType> stream = Stream.<ProductionType>builder().build()
//                .filter()

//        Stream<Production> stream = storehouse.getProductions().
//                .filter(x -> x.getKey().equals(" "));



//        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
//        Stream<Integer> stream = intList.stream()
//                .filter(x -> x > 0)
//                .filter(x -> x % 2 == 0)
//                .sorted(Comparator.naturalOrder());
//
//        stream.forEach(System.out::println);
        return filteredMap;
    }
}

