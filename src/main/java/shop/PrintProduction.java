package shop;

import java.util.Map;

public interface PrintProduction {
    default void printingProducts(Map<Integer, Production> productions) {
        if (productions!=null) {
            productions.forEach((key, value) -> System.out.println(key + " : " + value));
        } else System.out.println("Список товаров недоступен");
    }
}
