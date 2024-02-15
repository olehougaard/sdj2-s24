package dk.via.counter;

public class Counter {
    private int count;

    public Counter() {
        count = 0;
    }

    public synchronized void incrementCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
