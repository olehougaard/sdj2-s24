package dk.via.hotel;

import java.util.Objects;

public class Guest {
    private final String name;

    public Guest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Guest.class) {
            return false;
        }
        Guest other = (Guest) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
