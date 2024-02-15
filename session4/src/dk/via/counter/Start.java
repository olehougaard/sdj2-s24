package dk.via.counter;

public class Start {
    public static void main(String[] args) {
        Counter counter = new Counter();
        CounterIncrementer incrementer1 = new CounterIncrementer(counter);
        CounterIncrementer incrementer2 = new CounterIncrementer(counter);
        Thread thread1 = new Thread(incrementer1);
        Thread thread2 = new Thread(incrementer2);
        thread1.start();
        thread2.start();
    }
}
