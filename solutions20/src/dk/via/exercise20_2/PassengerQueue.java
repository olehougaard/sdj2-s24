package dk.via.exercise20_2;

public interface PassengerQueue {
    void putPassengerInQueue(Passenger p);
    Passenger getNextPassenger() throws InterruptedException;
}
