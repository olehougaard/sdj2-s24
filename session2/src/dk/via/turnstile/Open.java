package dk.via.turnstile;

public class Open implements State {
    @Override
    public void coin(Turnstile turnstile) {
        turnstile.returnCoin();
        turnstile.setState(this);
    }

    @Override
    public void pass(Turnstile turnstile) {
        turnstile.setState(new Closed());
    }

    @Override
    public void onEntry(Turnstile turnstile) {
        turnstile.unlock();
    }
}
