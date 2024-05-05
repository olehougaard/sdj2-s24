package dk.via.hotel;

public class Room {
    private final int number;
    private Guest guest;
    private Bed bed;

    public Room(int number, String bedType) {
        this.number = number;
        this.guest = null;
        this.bed = new Bed(bedType);
    }

    public int getNumber() {
        return number;
    }

    public int getFloor() {
        return number % 100;
    }

    public double getPrice() {
        if (bed.isSingle())
            return 59.50;
        else if (bed.isDouble())
            return 72.40;
        else
            return 89;
    }

    public Guest getGuest() {
        return guest;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public boolean isOccupied() {
        return guest != null;
    }

    public void registerGuest(Guest guest) {
        this.guest = guest;
    }

    public void vacate() {
        this.guest = null;
    }

    public String getBedType() {
        if (bed.isSingle())
            return "Single";
        else if (bed.isDouble())
            return "Double";
        else
            return "King size";
    }
}
