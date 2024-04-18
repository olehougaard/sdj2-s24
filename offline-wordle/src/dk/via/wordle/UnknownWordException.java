package dk.via.wordle;

public class UnknownWordException extends RuntimeException {
    public UnknownWordException(String word) {
        super(word);
    }
}
