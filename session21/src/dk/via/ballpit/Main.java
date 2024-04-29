package dk.via.ballpit;

import dk.via.ballpit.accessmanager.FairAccessManager;

public class Main {
	public static void main(String[] args) {
		BallPit pit = new UnsafeBallPit(20);
        FairAccessManager accessManager = new FairAccessManager(pit);
		Thread writerThread = new Thread(new dk.via.ballpit.accessmanager.BallPitPainter(accessManager));
		Thread readerThread = new Thread(new dk.via.ballpit.accessmanager.BallPitPrinter(accessManager));
		writerThread.start();
		readerThread.start();
	}
}
