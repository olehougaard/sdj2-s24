package dk.via.phone;

public class Silent implements SpeakerState {
    public void alert(Phone phone) {

    }

    public void click(Phone phone) {
        phone.setState(new Sound());
    }
}
