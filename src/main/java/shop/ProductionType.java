package shop;

import java.util.ArrayList;
import java.util.List;

public class ProductionType {
    private List<Production> productions;
    private final String typeName;

    public ProductionType(Production production, String typeName) {
        productions = new ArrayList<>();
        productions.add(production);
        this.typeName = typeName;
    }

    public ProductionType(List<Production> productions, String typeName) {
        this.productions = productions;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

}
