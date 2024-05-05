package dk.via.hotel;

public class Bed {
    private String type;

    public Bed(String type) {
        this.type = type;
    }

    public boolean isSingle() {
        return "Single".equals(type);
    }

    public boolean isDouble() {
        return "Double".equals(type);
    }

    public boolean isKingSize() {
        return "King size".equals(type);
    }
}
