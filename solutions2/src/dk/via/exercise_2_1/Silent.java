package dk.via.exercise_2_1;

public class Silent implements SpeakerState {
    public void alert(Phone phone) {

    }

    public void click(Phone phone) {
        phone.setState(new Sound());
    }
}
