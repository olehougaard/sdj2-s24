package dk.via.pi;

import java.math.BigDecimal;

public class PiService {
    private final DecimalCache cache;

    public PiService() {
        this.cache = new DecimalCache();
    }

    public BigDecimal getPi(int digits) {
        if (!cache.contains(digits)) {
            computePi(digits);
        }
        return cache.get(digits);
    }

    private void computePi(int digits) {
        PiRunnable piRunnable = new PiRunnable(digits);
        Thread thread = new Thread(piRunnable);
        thread.start();
        try {
            cache.put(digits, piRunnable.getPi());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
