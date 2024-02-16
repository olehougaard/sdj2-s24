package dk.via.counter;

public class DoubleCounter {
    private int countDooku;
    private int countDracula;

    private final Object dookuLock;
    private final Object draculaLock;

    public DoubleCounter() {
        countDooku = 0;
        countDracula = 0;
        dookuLock = new Object();
        draculaLock = new Object();
    }

    public void incrementCountDooku() {
        synchronized(dookuLock) {
            countDooku++;
        }
    }

    public void incrementCountDracula() {
        synchronized(draculaLock) {
            countDracula++;
        }
    }

    public int getCountDooku() {
        return countDooku;
    }

    public int getCountDracula() {
        return countDracula;
    }
}
