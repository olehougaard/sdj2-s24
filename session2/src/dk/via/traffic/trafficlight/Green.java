package dk.via.traffic.trafficlight;

public class Green implements State {
    @Override
    public void next(TrafficLight light) {
        light.turnOff(Lights.GREEN);
        light.turnOn(Lights.YELLOW);
        light.setState(new Yellow());
    }

    public LightColor getColor() {
        return LightColor.GREEN;
    }
}
