package dk.via.exercise_2_3;

public class Sound implements SpeakerState {
    public void alert(Phone phone) {
        System.out.println("DRRING");
    }

    @Override
    public void volumeUp(Phone phone) {
        if (phone.getVolume() < 10) {
            phone.setVolume(phone.getVolume() + 1);
        }
    }

    @Override
    public void volumeDown(Phone phone) {
        if (phone.getVolume() == 1) {
            phone.setVolume(0);
            phone.setState(new Vibrate());
        } else {
            phone.setVolume(phone.getVolume() - 1);
        }
    }

    @Override
    public void onEntry(Phone phone) {
        if (phone.getVolume() == 0) {
            phone.setVolume(1);
        }
    }

    public void click(Phone phone) {
        phone.setState(new Vibrate());
    }
}
