package dk.via.exercise_2_1;

public class Sound implements SpeakerState {
    public void alert(Phone phone) {
        System.out.println("DRRING");
    }

    public void click(Phone phone) {
        phone.setState(new Vibrate());
    }
}
