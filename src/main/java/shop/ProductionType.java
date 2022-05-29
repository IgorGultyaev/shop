package shop;

import java.util.List;

public class ProductionType {

    private static final String errorConstructorParameters = "Список продукции не должен быть пустым";
    private static final String errorProductionTypInList = "Поле типа продукта в однотипных товара должно быть одинаковым";
    private static String typeName;
    private List<Production> productions;

    private ProductionType(List<Production> productions) throws ProductionTypeException {
        String nameFistProduct;
        boolean checkingList = false;
        if (productions.size() == 0) {
            throw new ProductionTypeException(errorConstructorParameters);
        } else {
            nameFistProduct = productions.get(0).getProductionName();
            for (Production production : productions) {
                checkingList = production.getProductionName().equals(nameFistProduct);
            }
            if (!checkingList) {
                throw new ProductionTypeException(errorProductionTypInList);
            } else {
                this.productions = productions;
                typeName = nameFistProduct;
            }

        }

    }

    public ProductionType addProductionTypeList(List<Production> productions) throws ProductionTypeException {
        String nameFistProduct;
        if (productions.size() == 0) {
            throw new ProductionTypeException(errorConstructorParameters);
        } else {
            nameFistProduct = productions.get(0).getProductionName();
            boolean checkingList = false;
            if (productions.size() == 0) {
                for (Production production : productions) {
                    checkingList = production.getProductionName().equals(nameFistProduct);
                }
                if (!checkingList) {
                    throw new ProductionTypeException(errorProductionTypInList);
                } else if (Storehouse.getProductions().containsKey(nameFistProduct)) {
                    Storehouse.add()
                    for (Production production : productions) {

                    }
                    this.productions = productions;
                    typeName = nameFistProduct;
                }
            }
        }


    }

    public static String getTypeName() {
        return typeName;
    }
}