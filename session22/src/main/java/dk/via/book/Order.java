package dk.via.book;

import java.util.ArrayList;

public class Order {
    private final ArrayList<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Book book) {
        lines.stream()
                .filter(line -> line.getItem().equals(book))
                .findFirst()
                .ifPresentOrElse(OrderLine::addItem, () -> lines.add(new OrderLine(book)));
    }

    public double getTotal() {
        return lines.parallelStream()
                .mapToDouble(OrderLine::getPrice)
                .sum();
    }
}
