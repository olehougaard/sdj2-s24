package dk.via.exercise_2_2;

public class Red implements State {
    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.turnOn(Lights.YELLOW);
        trafficLight.setState(new YellowRed());
    }
}
