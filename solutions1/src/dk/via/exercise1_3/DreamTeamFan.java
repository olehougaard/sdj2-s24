package dk.via.exercise1_3;

public class DreamTeamFan {
    public DreamTeamFan(SoccerMatch match) {
        match.addPropertyChangeListener("DreamTeamScore", (e)-> System.out.println("Dream Team fan: GOOOOOOOOOOAL!"));
        match.addPropertyChangeListener("OldBoysScore", (e)-> System.out.println("Dream Team fan: Booooo"));
    }
}
