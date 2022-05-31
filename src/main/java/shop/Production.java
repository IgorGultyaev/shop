package shop;

//TODO настроить продукты, под сделанный склад и Типы продуктов
public class Production {
    private final String productionType;
    private final double productionPrice;
    private  String productionName; // TODO попробовать сделать ссылкой
    private int number;
    private int productionID;

    public Production(String productionType, double productionPrice, String productionName, int number, int productionID) {
        this.productionType = productionType;
        this.productionPrice = productionPrice;
        this.productionName = productionName;
        this.number = number;
        this.productionID = productionID;
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

    @Override
    public String toString() {
        return   "Номер:" + productionID + " " + productionName +
                " Цена:" + productionPrice + "₽ на складе:" + number + "шт. || ";
    }

    public int getProductionID() {
        return productionID;
    }

}
