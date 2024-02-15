package dk.via.pi;

import java.math.BigDecimal;

public class PiRunnable implements Runnable {
    private final int digits;
    private BigDecimal pi;

    public PiRunnable(int digits) {
        this.digits = digits;
    }

    public synchronized void run() {
        pi = Pi.computePi(digits);
        notifyAll();
    }

    public synchronized BigDecimal getPi() throws InterruptedException {
        wait();
        return pi;
    }
}
