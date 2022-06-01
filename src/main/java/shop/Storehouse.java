package shop;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Storehouse implements Filter {
    private static Storehouse storehouse = null;
    private Map<String, ProductionType> productions;
    private Map<String, ProductionType> filteredProductions;


    private Storehouse() {
        this.productions = new HashMap<>();
    }

    public static Storehouse getStorehouse() {
        if (storehouse == null) {
            return new Storehouse();
        } else return storehouse;
    }

    public void addProduction(Production production) {

        //TODO при добавлении на склад необходимо сделать проверку уникальности номера

        String productionType = production.getProductionType();
        List<Production> list = new ArrayList<>();
        list.add(production);
        if (productions.containsKey(productionType)) {
            productions.get(productionType).getProductions().add(production);
        } else productions.put(production.getProductionType(), (new ProductionType(list)));
    }

    public void printStorehouse() {
        productions.forEach((key, value)
                -> System.out.println(key + " " +
                (productions.getOrDefault(value, value))));
    }

    Map<String, ProductionType> getProductions() {
        return productions;
    }

// TODO доделать стрим в стриме
    public void filterProduction(String... param) throws FiltersParamException {

//        if (param.length !=1 ) {
//            throw new FiltersParamException("Недопустимое количество параметров. Для данного фильтра установите 1 параметр");
//        } else {
//            Map<String, ProductionType> filteredMap = productions.entrySet().stream()
//                    .filter(x ->"Смартфон".equals(x.getKey()))
//                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//            this.productions = filteredMap;

        if (param.length != 1) {
            throw new FiltersParamException("Недопустимое количество параметров. Для данного фильтра установите 1 параметр");
        } else {


//            Stream<ProductionType>

            this.filteredProductions = productions.values().stream()
                    .map(productionType -> productionType.getProductions().stream()
                            .filter(production -> production.getProductionPrice() < 2000)
                            .collect(Collectors.toList()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

/*
            Arrays.asList("a", "b", "c")
                    .stream()
                    .map(Function.identity()) // <- This,
                    .map(str -> str)          // <- is the same as this.
                    .collect(Collectors.toMap(
                            Function.identity(), // <-- And this,
                            str -> str));        // <-- is the same as this.
*/





//            Map < Integer , String > aMap
//                    = input. поток ( )
//                    . collect ( Collectors. toMap ( Function. identity ( ) ,
//                            String :: valueOf,
//                            ( k1, k2 ) - > k1 ) ) ) ;


//            Map<String, ProductionType> filteredMap = productions.values().stream()
//                    .map(productionType -> {
//                        return productionType.getProductions().stream()
//                                .filter(production -> production.getProductionPrice() < 2000)
//                                .collect(Collectors.toList());
//                    })
//                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//            this.productions = filteredMap;


//           Map<String, ProductionType> filteredMap = productions.entrySet().stream()
//                   .filter(x -> {
//                       List<Production> list = x.getValue().getProductions().stream()
//                               .filter(production -> production.getProductionPrice()<2000)
//                               .collect(Collectors.toList());
//                       return true;
//                   })
//                   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//           this.productions = filteredMap;


//                .filter(personUnit -> {
//               Function<Sex, Integer> ageT = x -> personUnit.getSex() == Sex.MAN ? 65 : 20;
//               return personUnit.getAge() > ageFrom && personUnit.getAge() < ageT.apply(personUnit.getSex());
//           })


//            System.out.println(filteredMap);

        }


    }

    @Override
    public void resetFilters() {

    }


}
