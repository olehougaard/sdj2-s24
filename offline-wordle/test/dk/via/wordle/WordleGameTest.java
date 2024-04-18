package dk.via.wordle;

import org.junit.jupiter.api.BeforeEach;

import java.rmi.RemoteException;

class WordleGameTest {
    private WordleGame game;

    @BeforeEach
    void setUp() throws RemoteException {
        // Replace the words with the words you want. randomWord() always returns "Word1" in this setup.
        Dictionary dictionary = new FakeRandomDictionary("Word1", "Word2", "Word3");
        game = new WordleGame(5, dictionary);
    }

}
