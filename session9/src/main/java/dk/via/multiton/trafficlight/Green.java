package dk.via.multiton.trafficlight;

public class Green extends State {
    Green() {}

    @Override
    public void next(TrafficLight light) {
        light.turnOff(Lights.GREEN);
        light.turnOn(Lights.YELLOW);
        light.setState(State.getInstance(LightColor.YELLOW));
    }

    public LightColor getColor() {
        return LightColor.GREEN;
    }
}
