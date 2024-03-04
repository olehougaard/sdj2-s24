package dk.via.multiton.trafficlight;

public class Red extends State {
    Red() {}

    @Override
    public void next(TrafficLight light) {
        light.turnOn(Lights.YELLOW);
        light.setState(State.getInstance(LightColor.RED_YELLOW));
    }

    public LightColor getColor() {
        return LightColor.RED;
    }
}
