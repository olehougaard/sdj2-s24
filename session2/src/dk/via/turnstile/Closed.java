package dk.via.turnstile;

public class Closed implements State {
    @Override
    public void coin(Turnstile turnstile) {
        turnstile.setState(new Open());
    }

    @Override
    public void pass(Turnstile turnstile) {
        turnstile.alarm();
        turnstile.setState(this);
    }

    @Override
    public void onEntry(Turnstile turnstile) {
        turnstile.lock();
    }
}
