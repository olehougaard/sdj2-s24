package dk.via.traffic;

import dk.via.traffic.trafficlight.Lights;
import dk.via.traffic.trafficlight.TrafficLight;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TaxiDriver implements PropertyChangeListener {
    private Car car;

    public TaxiDriver(Car car) {
        this.car = car;
    }

    private void onLightChange(TrafficLight trafficLight) {
        if (trafficLight.isTurnedOn(Lights.GREEN)) {
            if (!car.isRunning()) car.start();
            car.accelerate();
            trafficLight.removePropertyChangeListener(this);
        } else if (trafficLight.isTurnedOn(Lights.RED) && trafficLight.isTurnedOn(Lights.YELLOW)) {
            car.start();
        } else if (trafficLight.isTurnedOn(Lights.YELLOW)) {
            // Nothing
        } else {
            car.stop();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TrafficLight subject = (TrafficLight) evt.getSource();
        onLightChange(subject);
    }
}
