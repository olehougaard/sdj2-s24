package dk.via.exercise18_1;

public class UnknownWordException extends RuntimeException {
    public UnknownWordException(String word) {
        super(word);
    }
}
