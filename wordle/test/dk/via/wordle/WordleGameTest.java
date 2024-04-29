package dk.via.wordle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.rmi.RemoteException;
import java.util.List;

import static dk.via.wordle.Result.*;
import static org.junit.jupiter.api.Assertions.*;

class WordleGameTest {
    private Dictionary dictionary;
    private WordleGame game;

    @BeforeEach
    void setUp() throws RemoteException {
        dictionary = Mockito.mock(Dictionary.class);
        game = new WordleGame(5, dictionary);
    }

    @Test
    void too_short_words_are_not_allowed_as_guesses() throws RemoteException {
        assertThrows(IllegalArgumentException.class, () -> game.guess("ABCD"));
    }

    @Test
    void too_long_words_are_not_allowed_as_guesses() throws RemoteException {
        assertThrows(IllegalArgumentException.class, () -> game.guess("ABCDEF"));
    }

    @Test
    void the_server_isnt_called_if_words_have_wrong_length() throws RemoteException {
        assertThrows(IllegalArgumentException.class, () -> game.guess("ABCD"));
        assertThrows(IllegalArgumentException.class, () -> game.guess("ABCDEF"));
        Mockito.verify(dictionary, Mockito.never()).lookup(Mockito.anyString());
    }


}
