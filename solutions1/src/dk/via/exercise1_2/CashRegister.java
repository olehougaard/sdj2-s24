package dk.via.exercise1_2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CashRegister {
    // Define the support
    private double total;
    private final PropertyChangeSupport support;

    public CashRegister() {
        total = 0;
        // Initialize the support
        support = new PropertyChangeSupport(this);
    }

    public void completeSale() {
        double oldTotal = total;
        total = 0;
        // Fire the event
        support.firePropertyChange("total", oldTotal, total);
    }

    public void registerSale(double amount) {
        double oldTotal = total;
        total += amount;
        // Fire the event
        support.firePropertyChange("total", oldTotal, total);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
      // Add the listener
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
      // Remove the listener
        support.removePropertyChangeListener(listener);
    }
}
