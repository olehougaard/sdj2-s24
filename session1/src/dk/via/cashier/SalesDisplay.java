package dk.via.cashier;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SalesDisplay implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue().equals(0.0)) {
            System.out.println("Sale completed. Total = " + evt.getOldValue());
            System.out.println();
        }
    }
}
