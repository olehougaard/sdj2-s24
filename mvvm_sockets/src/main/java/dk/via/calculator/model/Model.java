package dk.via.calculator.model;

import java.beans.PropertyChangeListener;
import java.io.IOException;

public interface Model {
    double add(double a, double b);

    double subtract(double a, double b);

    double multiply(double a, double b);

    double divide(double a, double b);

    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);
}
