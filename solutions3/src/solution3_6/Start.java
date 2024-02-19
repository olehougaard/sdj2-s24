package solution3_6;

public class Start {
    private static void runWithRunnable() {
        TimedPrinter printer = new TimedPrinter(100);
        Thread thread = new Thread(printer);
        thread.start();
    }

    private static void runWithLambda() {
        Runnable printer = () -> {
            for(int i = 0; i < 100; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread = new Thread(printer);
        thread.start();
    }

    public static void main(String[] args) {
        runWithRunnable();
        runWithLambda();
    }
}
