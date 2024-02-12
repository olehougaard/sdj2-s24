package dk.via.charnums;

public class Numbers implements Runnable {
    private final int count;

    public Numbers(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 0; i < count; i++) {
            System.out.println(i);
        }
    }
}
