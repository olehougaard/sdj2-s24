package dk.via.numbers;

public class Numbers implements Runnable {
    private final int min;
    private final int max;

    public Numbers(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        for(int i = min; i < max; i++) {
            System.out.println(i);
        }
    }
}
