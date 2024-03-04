package dk.via.multiton.trafficlight;

public class Yellow extends State {
    Yellow() {}

    @Override
    public void next(TrafficLight light) {
        light.turnOff(Lights.YELLOW);
        light.turnOn(Lights.RED);
        light.setState(State.getInstance(LightColor.RED));
    }

    @Override
    public LightColor getColor() {
        return LightColor.YELLOW;
    }
}
