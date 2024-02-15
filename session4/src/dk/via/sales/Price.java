package dk.via.sales;

public class Price {
    private double x; // Slide-friendly name for price

    public Price(double x) {
        this.x = x;
    }

    public synchronized void addSalesTax() {
        double salesTax = x * .25;
        double total = x + salesTax;
        x = total;
    }

    public synchronized void applyRebate() {
        double rebate = x * .1;
        double price = x - rebate;
        x = price;
    }
}
