package dk.via.traffic.trafficlight;

public class Red implements State{
    @Override
    public void next(TrafficLight light) {
        light.turnOn(Lights.YELLOW);
        light.setState(new YellowRed());
    }

    public LightColor getColor() {
        return LightColor.RED;
    }
}
