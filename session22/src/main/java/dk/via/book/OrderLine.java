package dk.via.book;

import java.math.BigDecimal;

public class OrderLine {
    private final Book book;
    private int quantity;

    public OrderLine(Book book) {
        this.book = book;
        this.quantity = 1;
    }

    public Book getItem() {
        return book;
    }

    public void addItem() {
        quantity++;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return quantity * book.getPrice();
    }
}
