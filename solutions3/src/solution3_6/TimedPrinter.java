package solution3_6;

public class TimedPrinter implements Runnable {
    private final int count;

    public TimedPrinter(int count) {
        this.count = count;
    }

    public void run() {
        for(int i = 0; i < count; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
