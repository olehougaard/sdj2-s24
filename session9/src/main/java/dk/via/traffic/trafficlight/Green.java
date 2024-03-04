package dk.via.traffic.trafficlight;

public class Green implements State {
    private static Green instance;

    private Green() {}

    public static synchronized Green getInstance() {
        if (instance == null) {
            instance = new Green();
        }
        return instance;
    }

    @Override
    public void next(TrafficLight light) {
        light.turnOff(Lights.GREEN);
        light.turnOn(Lights.YELLOW);
        light.setState(Yellow.getInstance());
    }

    public LightColor getColor() {
        return LightColor.GREEN;
    }
}
