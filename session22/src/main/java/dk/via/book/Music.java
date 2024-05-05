package dk.via.book;

import java.math.BigDecimal;

public class Music {
    private final String id;
    private final String[] performers;
    private final BigDecimal price;

    public Music(String id, String[] performers, BigDecimal price) {
        this.id = id;
        this.performers = performers;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String[] getPerformers() {
        return performers;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
