package shop;

import org.jetbrains.annotations.NotNull;

public class Rating implements Comparable{
    Production production;
    int rating;
    String description;
    int views;
    int absoluteRating;

    public Rating(Production production, int rating, String description, Integer views, int i) {
        this.production = production;
        this.rating = rating;
        this.description = description;
        this.views = views;
    }

    public Production getProduction() {
        return production;
    }

    public double getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public Integer getViews() {
        return views;
    }

    public double getAbsoluteRating() {
        return absoluteRating;
    }

      public int compareTo(@NotNull Rating rating) {
        return Integer.compare(this.rating, rating.rating);
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "production=" + production +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", views=" + views +
                ", absoluteRating=" + absoluteRating +
                '}';
    }

    public void setViews(int views) {
        this.views = views;
    }
}

