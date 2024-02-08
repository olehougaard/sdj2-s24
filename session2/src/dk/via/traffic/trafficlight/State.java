package dk.via.traffic.trafficlight;

public interface State {
    void next(TrafficLight light);

    LightColor getColor();
}
