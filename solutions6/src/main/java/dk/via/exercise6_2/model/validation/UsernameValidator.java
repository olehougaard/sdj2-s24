package dk.via.exercise6_2.model.validation;

public class UsernameValidator {
    public static final int MINIMAL_LENGTH = 3;

    public static void validateUsername(String username) throws IllegalArgumentException {
        if (username == null || username.length() < MINIMAL_LENGTH) {
            throw new IllegalArgumentException("Username needs " + MINIMAL_LENGTH + " or more characters.");
        }
    }
}
