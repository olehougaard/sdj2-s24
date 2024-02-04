package dk.via.cashier;

import java.beans.PropertyChangeListener;

public class CashRegister {
    // Define the support
    private double total;

    public CashRegister() {
        total = 0;
        // Initialize the support
    }

    public void completeSale() {
        double oldTotal = total;
        total = 0;
        // Fire the event
    }

    public void registerSale(double amount) {
        total += amount;
        // Fire the event
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
      // Add the listener
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
      // Remove the listener
    }
}
