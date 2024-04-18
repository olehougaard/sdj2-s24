package dk.via.exercise17_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }
}
