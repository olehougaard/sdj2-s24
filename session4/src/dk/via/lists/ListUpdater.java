package dk.via.lists;

public class ListUpdater implements Runnable {
    private final ListContainer container;

    public ListUpdater(ListContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for(int i = 0; i <= 100_000; i++) {
            container.add(i);
        }
        System.out.println(container.size());
    }
}
