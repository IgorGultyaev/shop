package shop;

import java.util.Map;

public interface PrintProduction {
    Map<Integer, Production> productions = null;
    default void printingProducts() {
    }
}
