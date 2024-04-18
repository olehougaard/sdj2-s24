package dk.via.exercise17_3;

public class UnknownWordException extends RuntimeException {
    public UnknownWordException(String word) {
        super(word);
    }
}
