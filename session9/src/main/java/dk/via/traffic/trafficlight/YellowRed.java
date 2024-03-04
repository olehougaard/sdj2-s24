package dk.via.traffic.trafficlight;

public class YellowRed implements State {
    private static YellowRed instance;

    private YellowRed() {}

    public static YellowRed getInstance() {
        if (instance == null) {
            instance = new YellowRed();
        }
        return instance;
    }

    @Override
    public void next(TrafficLight light) {
        light.turnOff(Lights.YELLOW, Lights.RED);
        light.turnOn(Lights.GREEN);
        light.setState(Green.getInstance());
    }

    @Override
    public LightColor getColor() {
        return LightColor.RED_YELLOW;
    }
}
