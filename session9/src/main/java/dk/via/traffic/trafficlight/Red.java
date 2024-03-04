package dk.via.traffic.trafficlight;

public class Red implements State {
    private static Red instance;

    private Red() {}

    public static synchronized Red getInstance() {
        if (instance == null) {
            instance = new Red();
        }
        return instance;
    }

    @Override
    public void next(TrafficLight light) {
        light.turnOn(Lights.YELLOW);
        light.setState(YellowRed.getInstance());
    }

    public LightColor getColor() {
        return LightColor.RED;
    }
}
