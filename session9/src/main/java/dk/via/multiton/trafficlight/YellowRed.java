package dk.via.multiton.trafficlight;

public class YellowRed extends State {
    YellowRed() {}

    @Override
    public void next(TrafficLight light) {
        light.turnOff(Lights.YELLOW, Lights.RED);
        light.turnOn(Lights.GREEN);
        light.setState(State.getInstance(LightColor.GREEN));
    }

    @Override
    public LightColor getColor() {
        return LightColor.RED_YELLOW;
    }
}
