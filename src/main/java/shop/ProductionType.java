package shop;
import java.util.List;
import java.util.stream.Collectors;

public class ProductionType {

    private static final String errorConstructorParameters = "Список продукции не должен быть пустым";
    private static final String errorProductionTypInList = "Поле типа продукта в однотипных товара должно быть одинаковым";
    private List<Production> productions;

    ProductionType(List<Production> productions) {
        this.productions = productions;
    }

    public String getTypeName() {
        return this.productions.get(0).getDescription();
    }

    @Override
    public String toString() {
        return " " +  productions;
    }

    public List<Production> getProductions() {
        return productions;
    }






    public void filterProduction(String ... param) throws FiltersParamException {

        if (param.length !=1 ) {
            throw new FiltersParamException("Недопустимое количество параметров. Для данного фильтра установите 1 параметр");
        } else {
            List<Production> list = productions.stream()
                    .filter(x -> x.getProductionPrice()>2000)
                    .collect(Collectors.toList());





//            System.out.println(filteredMap);

        }




    }

// TODO попробовать сделать фильтр через set
}