package dk.via.multiton.trafficlight;

import java.util.HashMap;

public abstract class State {
    private static HashMap<LightColor, State> instances;

    protected State() {
        instances = new HashMap<>();
    }

    private static State createInstance(LightColor key) {
        return switch (key) {
            case RED -> new Red();
            case YELLOW -> new Yellow();
            case GREEN -> new Green();
            case RED_YELLOW -> new YellowRed();
        };
    }

    static synchronized State getInstance(LightColor key) {
        if (!instances.containsKey(key)) {
            instances.put(key, createInstance(key));
        }
        return instances.get(key);
    }

    public abstract void next(TrafficLight light);

    public abstract LightColor getColor();
}
