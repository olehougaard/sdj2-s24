package dk.via.exercise_2_3;

public class Phone {
    private SpeakerState state;
    private int volume;

    public Phone() {
        state = new Sound();
        volume = 5;
    }

    public void onClick() {
        state.click(this);
    }

    public void onMessage(String message) {
        System.out.println(message);
        state.alert(this);
    }

    void setState(SpeakerState state) {
        this.state = state;
    }

    public int getVolume() {
        return volume;
    }

    void setVolume(int volume) {
        this.volume = volume;
    }
}
