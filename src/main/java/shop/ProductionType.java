package shop;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProductionType {

    private static final String errorConstructorParameters = "Список продукции не должен быть пустым";
    private static final String errorProductionTypInList = "Поле типа продукта в однотипных товара должно быть одинаковым";
    private static String typeName;
    private final List<Production> productions;
    ProductionType(List<Production> productions) {
        this.productions = productions;

    }

    void addProductionTypeList(@NotNull List<Production> productions) throws ProductionTypeException {
        String nameFistProduct;
        if (productions.size() == 0) {
            throw new ProductionTypeException(errorConstructorParameters);
        } else {
            nameFistProduct = productions.get(0).getProductionName();
            boolean checkingList = false;

            for (Production production : productions) {
                checkingList = production.getProductionName().equals(nameFistProduct);
            }
            if (!checkingList) {
                throw new ProductionTypeException(errorProductionTypInList);
            } else {
                this.productions.addAll(productions);
            }
        }
    }

    public String getTypeName() {
        return this.productions.get(0).getProductionName();
    }
}