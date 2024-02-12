package dk.via.numbers;

import dk.via.charnums.Characters;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        Runnable numbersRunner1 = new Numbers(0, 25000);
        Runnable numbersRunner2 = new Numbers(25000, 50000);
        Runnable numbersRunner3 = new Numbers(50000, 75000);
        Runnable numbersRunner4 = new Numbers(75000, 100000);

        Thread thread1 = new Thread(numbersRunner1);
        Thread thread2 = new Thread(numbersRunner2);
        Thread thread3 = new Thread(numbersRunner3);
        Thread thread4 = new Thread(numbersRunner4);

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        thread4.start();
    }
}
