package dk.via.ballpit;

public class ReadOnlyProxy implements ReadOnlyBallPit {
    private final BallPit ballPit;

    public ReadOnlyProxy(BallPit ballPit) {
        this.ballPit = ballPit;
    }

    @Override
    public int getGreenBalls() {
        return ballPit.getGreenBalls();
    }

    @Override
    public int getRedBalls() {
        return ballPit.getRedBalls();
    }

    @Override
    public int getTotal() {
        return ballPit.getTotal();
    }
}
