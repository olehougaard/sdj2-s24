    package dk.via.hotel;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Hotel {
    private final String name;
    private final Room[] rooms;

    public Hotel(String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms.clone();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfRooms() {
        return rooms.length;
    }

    public long getNumberOfAvailableRooms() {
        return Stream.of(rooms)
            .filter((room) -> !room.isOccupied())
            .count();
    }

    public Room getFirstAvailableRoom() {
        return Stream.of(rooms)
                .filter((room) -> !room.isOccupied())
                .findFirst()
                .orElse(null);
    }

    public Room getFirstAvailableRoom(double maxPrice) {
        return Stream.of(rooms)
                .filter((room)->room.getPrice() < maxPrice)
                .filter((room1) -> !room1.isOccupied())
                .findFirst()
                .orElse(null);
    }

    public List<Room> getAllAvailableRooms() {
        return Stream.of(rooms)
                .filter((room) -> !room.isOccupied())
                .toList();
    }

    public List<Guest> getAllGuests() {
        return Stream.of(rooms)
                .map(Room::getGuest)
                .filter(Objects::nonNull)
                .toList();
    }

    public double getTotalRevenue() {
        return Stream.of(rooms)
                .filter(Room::isOccupied)
                .mapToDouble(Room::getPrice)
                .sum();
    }

    public boolean hasGuest(Guest guest) {
        return Stream.of(rooms)
                .map(Room::getGuest)
                .anyMatch(guest::equals);
    }

    public Room getRoom(Guest guest) {
        return Stream.of(rooms)
                .filter(Room::isOccupied)
                .filter((room)->room.getGuest().equals(guest))
                .findFirst()
                .orElse(null);
    }
}
