package shop;

//TODO настроить продукты, под сделанный склад и Типы продуктов
public class Production {
    private final String productionType;
    private final double productionPrice;
    private final String description; // TODO попробовать сделать ссылкой
    private final Integer productionID;
    private final String manufacturer;
    private int number;


    public Production(Integer id, String productionType, String manufacturer, String description, int number, double productionPrice) {
        this.productionType = productionType;
        this.productionPrice = productionPrice;
        this.description = description;
        this.number = number;
        this.productionID = id;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Номер:" + productionID + " " + manufacturer +" " + description +
                " Цена:" + productionPrice + "₽ на складе:" + number + "шт. || ";
    }

    public void printingAvailableProducts(){

    }

    public String getProductionType() {
        return productionType;
    }

    public double getProductionPrice() {
        return productionPrice;
    }

    public String getDescription() {
        return description;
    }

    public int getNumber() {
        return number;
    }

    public int getProductionID() {
        return productionID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

}
