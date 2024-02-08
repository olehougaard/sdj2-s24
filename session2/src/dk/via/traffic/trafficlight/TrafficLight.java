package dk.via.traffic.trafficlight;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrafficLight {
    private State state;
    private final Lights lights;
    private final PropertyChangeSupport support;

    public TrafficLight() {
        state = new Red();
        lights = new Lights();
        lights.turnOn(Lights.RED);
        lights.printLights();
        support = new PropertyChangeSupport(this);
    }

    void setState(State state) {
        this.state = state;
    }

    public LightColor getColor() {
        return state.getColor();
    }

    public void next() {
       LightColor oldColor = getColor();
       state.next(this);
       support.firePropertyChange("color", oldColor, getColor());
       lights.printLights();
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

    public void addPropertyChangeListener(PropertyChangeListener observer) {
        support.addPropertyChangeListener(observer);
    }

    public void removePropertyChangeListener(PropertyChangeListener observer) {
        support.removePropertyChangeListener(observer);
    }
}
