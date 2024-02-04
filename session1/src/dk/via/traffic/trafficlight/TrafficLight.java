package dk.via.traffic.trafficlight;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrafficLight {
    private LightColor color;
    private final Lights lights;
    private final PropertyChangeSupport support;

    public TrafficLight() {
        color = LightColor.RED;
        lights = new Lights();
        lights.turnOn(Lights.RED);
        lights.printLights();
        support = new PropertyChangeSupport(this);
    }

    public LightColor getColor() {
        return color;
    }

    public void next() {
       LightColor oldColor = color;
        switch (color) {
            case GREEN:
                color = LightColor.YELLOW;
                turnOff(Lights.GREEN);
                turnOn(Lights.YELLOW);
                break;
            case YELLOW:
                color = LightColor.RED;
                turnOff(Lights.YELLOW);
                turnOn(Lights.RED);
                break;
            case RED:
                color = LightColor.RED_YELLOW;
                turnOn(Lights.YELLOW);
                break;
            case RED_YELLOW:
               color = LightColor.GREEN;
               turnOff(Lights.RED, Lights.YELLOW);
               turnOn(Lights.GREEN);
        }
        lights.printLights();
        support.firePropertyChange("light", oldColor, color);
    }

    public boolean isTurnedOn(String light) {
        return lights.isTurnedOn(light);
    }

    public String getStatus() {
        return lights.getStatus();
    }

    void turnOn(String... lights) {
        this.lights.turnOn(lights);
    }

    void turnOff(String... lights) {
        this.lights.turnOff(lights);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(propertyName, listener);
    }
}
