package dk.via.traffic.trafficlight;

public class Yellow implements State {
    @Override
    public void next(TrafficLight light) {
        light.turnOff(Lights.YELLOW);
        light.turnOn(Lights.RED);
        light.setState(new Red());
    }

    @Override
    public LightColor getColor() {
        return LightColor.YELLOW;
    }
}
