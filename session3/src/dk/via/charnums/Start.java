package dk.via.charnums;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        Runnable numbersRunner = new Numbers(500);
        Runnable charactersRunner = new Characters(20);
        Thread numbersThread = new Thread(numbersRunner);
        Thread charactersThread = new Thread(charactersRunner);

        numbersThread.start();
        charactersThread.start();
        numbersThread.join();
        charactersThread.join();
        System.out.println("Finished");
    }
}
