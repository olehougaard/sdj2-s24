package dk.via.phone;

public class Vibrate implements SpeakerState {
    public void alert(Phone phone) {
        System.out.println("BZZZZ");
    }

    public void click(Phone phone) {
        phone.setState(new Silent());
    }
}
