package dk.via.exercise17_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberListTest {

    private NumberList list;

    @BeforeEach
    void setUp() {
        list = new NumberList();
    }

    @Test
    void a_new_number_list_is_empty() {
        assertTrue(list.isEmpty());
    }

    @Test
    void a_new_number_list_has_size_0() {
        assertEquals(0, list.size());
    }

    @Test
    void a_new_number_list_has_sum_0() {
        assertEquals(0, list.sum());
    }

    @Test
    void adding_to_a_new_list_increases_the_size() {
        list.add(7);
        assertEquals(1, list.size());
    }

    @Test
    void adding_to_a_new_list_puts_new_element_in_position_0() {
        list.add(7);
        assertEquals(7, list.get(0));
    }

    @Test
    void removing_from_a_new_list_decreases_the_size() {
        list.add(7);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    void adding_to_a_new_list_adds_to_the_sum() {
        list.add(7);
        assertEquals(7, list.sum());
    }

    @Test
    void adding_an_element_to_a_nonempty_list_adds_to_the_sum() {
        list.add(7);
        list.add(4);
        assertEquals(11, list.sum());
    }

    @Test
    void removing_an_element_subtracts_from_the_sum() {
        list.add(7);
        list.add(4);
        list.remove(0);
        assertEquals(4, list.sum());
    }

    @Test
    void removing_an_element_returns_the_element() {
        list.add(7);
        list.add(4);
        double element = list.remove(0);
        assertEquals(7, element);
    }

    @Test
    void you_can_get_the_element_from_the_size_minus_1() {
        list.add(7);
        list.add(4);
        assertEquals(4, list.get(list.size() - 1));
    }


    @Test
    void you_can_remove_the_element_from_the_size_minus_1() {
        list.add(7);
        list.add(4);
        assertEquals(4, list.remove(list.size() - 1));
    }

    @Test
    void you_cant_get_the_element_from_index_equals_size() {
        list.add(7);
        list.add(4);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->{
            list.get(list.size());
        });
    }

    @Test
    void you_cant_remove_the_element_from_index_equals_size() {
        list.add(7);
        list.add(4);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->{
            list.remove(list.size());
        });
    }

    @Test
    void you_cant_get_the_element_from_below_index_0() {
        list.add(7);
        list.add(4);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->{
            list.get(-1);
        });
    }

    @Test
    void you_cant_remove_the_element_from_below_index_0() {
        list.add(7);
        list.add(4);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->{
            list.remove(-1);
        });
    }
}