package dk.via.cashier;

public class Start {
    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();
        SalesDisplay salesDisplay = new SalesDisplay();
        RunningTotalDisplay runningTotalDisplay = new RunningTotalDisplay();

        cashRegister.addPropertyChangeListener(salesDisplay);
        cashRegister.addPropertyChangeListener(runningTotalDisplay);

        cashRegister.registerSale(3);
        cashRegister.registerSale(1.1);
        cashRegister.registerSale(2);
        cashRegister.completeSale();

        cashRegister.registerSale(22);
        cashRegister.registerSale(5);
        cashRegister.completeSale();
    }
}
