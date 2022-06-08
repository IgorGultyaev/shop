package shop;

public class Production {
    private final String productionType;
    private final double productionPrice;
    private final String description;
    private final Integer productionID;
    private final String manufacturer;
    private final int number;

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
        return "Номер:" + productionID + " " + productionType + " " + manufacturer + " " + description +
                " Цена:" + productionPrice + " || ";
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

    public Integer getProductionID() {
        return productionID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

}
