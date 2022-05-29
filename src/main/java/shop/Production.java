package shop;

import java.util.List;
//TODO настроить продукты, под сделанный склад и Типы продуктов
public class Production {
    private final String productionType;
    private final double productionPrice;
    private  String productionName; // TODO попробовать сделать ссылкой
    private int number;

    public Production(String productionType, double productionPrice, String productionName, int number) {
        this.productionType = productionType;
        this.productionPrice = productionPrice;
        this.productionName = productionName;
        this.number = number;
    }

    public String getProductionType() {
        return productionType;
    }

    public double getProductionPrice() {
        return productionPrice;
    }

    public String getProductionName() {
        return productionName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
