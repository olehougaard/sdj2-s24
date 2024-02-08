package dk.via.turnstile;

public class Turnstile {
    private State state;

    public Turnstile() {
        state = new Closed();
    }

    void setState(State state) {
        this.state = state;
        this.state.onEntry(this);
    }

    public void coin() {
        state.coin(this);
    }

    public void pass() {
        state.pass(this);
    }

    void alarm() {
        System.out.println("alarm");
    }

    void returnCoin() {
        System.out.println("coin");
    }

    void lock() {
        System.out.println("lock");
    }

    void unlock() {
        System.out.println("unlock");
    }
 }
