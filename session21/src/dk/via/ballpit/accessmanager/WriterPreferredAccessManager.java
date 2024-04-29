package dk.via.ballpit.accessmanager;

import dk.via.ballpit.BallPit;
import dk.via.ballpit.ReadOnlyBallPit;

public class WriterPreferredAccessManager implements AccessManager {
    private final BallPit ballPit;
    private int readers;
    private int writers;
    private int writersWaiting;

    public WriterPreferredAccessManager(BallPit ballPit) {
        this.ballPit = ballPit;
        this.readers = 0;
        this.writers = 0;
        this.writersWaiting = 0;
    }

    @Override
    public synchronized void releaseRead() {
        readers--;
        if (readers == 0) {
            notifyAll();
        }
    }

    @Override
    public synchronized ReadOnlyBallPit requestRead() throws InterruptedException {
        while(writers > 0 || writersWaiting > 0) {
            wait();
        }
        readers++;
        return ballPit;
    }

    @Override
    public synchronized void releaseWrite() {
        writers--;
        if (writers == 0) {
            notifyAll();
        }
    }

    @Override
    public synchronized BallPit requestWrite() throws InterruptedException {
        writersWaiting++;
        while(writers > 0 || readers > 0) {
            wait();
        }
        writers++;
        writersWaiting--;
        return ballPit;
    }
}
