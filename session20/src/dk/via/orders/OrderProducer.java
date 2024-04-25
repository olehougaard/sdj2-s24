package dk.via.orders;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class OrderProducer implements Runnable {
    private final BlockingQueue<Order> queue;

    public OrderProducer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    private Order createOrder() {
        Customer donaldDuck = new Customer("Donald Duck", "dd@disney.com", "1313 Webfoot Walk");
        ArrayList<OrderLine> orderLines = new ArrayList<>();
        return new Order(donaldDuck, orderLines);
    }

    @Override
    public void run() {
        while(true) {
            Order order = createOrder();
            try {
                queue.put(order);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
