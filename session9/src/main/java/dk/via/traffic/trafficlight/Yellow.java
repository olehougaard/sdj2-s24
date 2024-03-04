package dk.via.traffic.trafficlight;

public class Yellow implements State {
    private static Yellow instance;

    private Yellow() {}

    public static synchronized Yellow getInstance() {
        if (instance == null) {
            instance = new Yellow();
        }
        return instance;
    }

    @Override
    public void next(TrafficLight light) {
        light.turnOff(Lights.YELLOW);
        light.turnOn(Lights.RED);
        light.setState(Red.getInstance());
    }

    @Override
    public LightColor getColor() {
        return LightColor.YELLOW;
    }
}
