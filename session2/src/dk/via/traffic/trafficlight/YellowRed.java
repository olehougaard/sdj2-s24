package dk.via.traffic.trafficlight;

public class YellowRed implements State {
    @Override
    public void next(TrafficLight light) {
        light.turnOff(Lights.YELLOW, Lights.RED);
        light.turnOn(Lights.GREEN);
        light.setState(new Green());
    }

    @Override
    public LightColor getColor() {
        return LightColor.RED_YELLOW;
    }
}
