package dk.via.orders;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class OrderConsumer implements Runnable {
    private final BlockingQueue<Order> queue;

    public OrderConsumer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    private void handle(Order order) {

    }

    public void run() {
        while(true) {
            try {
                Order order = queue.take();
                handle(order);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
