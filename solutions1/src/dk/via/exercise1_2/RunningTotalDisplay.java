package dk.via.exercise1_2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RunningTotalDisplay implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("New total: " + evt.getNewValue());
    }
}
