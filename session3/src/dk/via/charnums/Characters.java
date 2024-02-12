package dk.via.charnums;

public class Characters implements Runnable {
    private final int count;
    public Characters(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 0; i < count; i++) {
            for (char c = 'A'; c <= 'Z'; c++) {
                System.out.println(c);
            }
        }
    }
}
