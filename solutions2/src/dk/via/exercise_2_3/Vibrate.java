package dk.via.exercise_2_3;

public class Vibrate implements SpeakerState {
    public void alert(Phone phone) {
        System.out.println("BZZZZ");
    }

    @Override
    public void volumeUp(Phone phone) {
        phone.setState(new Sound());
    }

    @Override
    public void volumeDown(Phone phone) {

    }

    @Override
    public void onEntry(Phone phone) {

    }

    public void click(Phone phone) {
        phone.setState(new Silent());
    }
}
