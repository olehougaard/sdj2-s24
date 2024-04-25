package dk.via.exercise19_4;

public class ConsoleLogger implements Logger{
    @Override
    public void log(String txt) {
        System.out.println(txt);
    }
}
