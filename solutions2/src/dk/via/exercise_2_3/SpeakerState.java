package dk.via.exercise_2_3;

public interface SpeakerState {
    void click(Phone phone);
    void alert(Phone phone);

    void volumeUp(Phone phone);

    void volumeDown(Phone phone);

    void onEntry(Phone phone);
}
