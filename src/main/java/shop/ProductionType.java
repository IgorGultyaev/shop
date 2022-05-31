package shop;
import java.util.List;

public class ProductionType {

    private static final String errorConstructorParameters = "Список продукции не должен быть пустым";
    private static final String errorProductionTypInList = "Поле типа продукта в однотипных товара должно быть одинаковым";
    private List<Production> productions;

    ProductionType(List<Production> productions) {
        this.productions = productions;
    }

    public String getTypeName() {
        return this.productions.get(0).getProductionName();
    }

    @Override
    public String toString() {
        return " " +  productions;
    }

    public List<Production> getProductions() {
        return productions;
    }

// TODO попробовать сделать фильтр через set
}