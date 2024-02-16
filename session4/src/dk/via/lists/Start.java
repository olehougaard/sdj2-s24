package dk.via.lists;

public class Start {
    public static void main(String[] args) {
        ListContainer container = new ListContainer();
        ListUpdater updater1 = new ListUpdater(container);
        ListUpdater updater2 = new ListUpdater(container);
        Thread thread1 = new Thread(updater1);
        Thread thread2 = new Thread(updater2);
        thread1.start();
        thread2.start();
    }
}
