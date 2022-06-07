package shop;

import java.util.ArrayList;
import java.util.Map;

public class Filter implements FilterProductionHashtag, PrintProduction, FilterProductionByPrice, FilterProduction {
    private static Filter filter = null;
    private ArrayList<Rating> ratings = new ArrayList<>();
    private ArrayList<Production> views = new ArrayList<>();

    private Filter() {
    }

    public static Filter getFilter() {
        if (filter == null) {
            return new Filter();
        } else return filter;
    }

    private void addRequest(Map<Integer, Production> productions) {

        productions.forEach((key, value) -> views.add(value));
    }

    public Map<Integer, Production> filterHashtag(Map<Integer, Production> productions, String hashtag) {

        printingProducts(filterProductionHashtag(productions, hashtag));
        addRequest(filterProductionHashtag(productions, hashtag));
        return filterProductionHashtag(productions, hashtag);
    }

    public Map<Integer, Production> filterByPrice(Map<Integer, Production> productions, double min, double max) {

        printingProducts(filterProductionByPrice(productions, min, max));
        addRequest(filterProductionByPrice(productions, min, max));
        return filterProductionByPrice(productions, min, max);
    }

    public Map<Integer, Production> filterByManufacturer(Map<Integer, Production> productions, String manufacturer) {

        printingProducts(filterProductionManufacturer(productions, manufacturer));
        addRequest(filterProductionHashtag(productions, manufacturer));
        return filterProductionHashtag(productions, manufacturer);
    }

    public ArrayList<Production> getRecommend() {
        boolean contains = false;
        for (Production p : views) {
            for (Rating r : ratings) {
                System.out.println(1);
                if (p.getProductionID() == r.getProduction().getProductionID()) {
                    contains = true;
                    r.setViews(r.getViews() + 1);
                }
            }
            if (!contains) {
                ratings.add(new Rating(p, 0, null, 1, 1));
            }
        }
        views.clear();
        ArrayList<Production> recommend = new ArrayList<>();
        ratings.forEach((value) -> recommend.add(value.getProduction()));
        return recommend;
    }
}
