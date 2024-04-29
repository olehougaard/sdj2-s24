package dk.via.ballpit.accessmanager;

import dk.via.ballpit.BallPit;
import dk.via.ballpit.ReadOnlyBallPit;
import dk.via.ballpit.ReadOnlyProxy;

public class FairAccessManager implements AccessManager {
    private final BallPit ballPit;
    private final ReadOnlyBallPit readOnlyBallPit;
    private int readers;
    private int writers;
    private int current;
    private int next;

    public FairAccessManager(BallPit ballPit) {
        this.ballPit = ballPit;
        this.readOnlyBallPit = new ReadOnlyProxy(ballPit);
        this.readers = 0;
        this.writers = 0;
        this.current = 0;
        this.next = 0;
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
        int myNumber = next;
        next++;
        while (myNumber != current) {
            wait();
        }
        while(writers > 0) {
            wait();
        }
        readers++;
        current++;
        notifyAll();
        return readOnlyBallPit;
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
        int myNumber = next;
        next++;
        while(myNumber != current) {
            wait();
        }
        while(writers > 0 || readers > 0) {
            wait();
        }
        writers++;
        current++;
        notifyAll();
        return ballPit;
    }
}
