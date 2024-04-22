package dk.via.exercise18_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberListTest {

    private NumberList list;

    @BeforeEach
    void setUp() {
        list = new NumberList();
    }

    // Given a new NumberList, it
    @Test
    void a_new_number_list_is_empty() {
        assertTrue(list.isEmpty());
    }

    @Test
    void a_new_number_list_has_size_0() {
        assertEquals(0, list.size());
    }

    @Test
    void a_new_number_list_has_no_element_0() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void cannot_remove_from_a_new_number_list() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void a_new_number_list_has_sum_of_0() {
        assertEquals(0, list.sum());
    }

    @Test
    void adding_an_element_makes_the_size_1() {
        list.add(3);
        assertEquals(1, list.size());
    }

    @Test
    void adding_an_element_makes_the_list_non_empty() {
        list.add(3);
        assertFalse(list.isEmpty());
    }

    @Test
    void adding_an_element_puts_it_in_index_0() {
        list.add(3);
        assertEquals(3, list.get(0));
    }

    @Test
    void removing_an_added_an_element_returns_it() {
        list.add(3);
        assertEquals(3, list.remove(0));
    }

    @Test
    void removing_an_added_an_element_makes_the_list_smaller() {
        list.add(3);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    void adding_an_element_adds_it_to_the_sum() {
        list.add(3);
        assertEquals(3, list.sum());
    }

    @Test
    void adding_two_elements_puts_them_in_index_0_and_1_respectively() {
        list.add(3);
        list.add(.5);
        assertEquals(3, list.get(0));
        assertEquals(.5, list.get(1));
    }

    @Test
    void removing_first_element_puts_second_in_index_0() {
        list.add(3);
        list.add(.5);
        list.remove(0);
        assertEquals(.5, list.get(0));
    }

    @Test
    void adding_two_elements_adds_both_to_sum() {
        list.add(3);
        list.add(.5);
        assertEquals(3.5, list.sum());
    }

    @Test void adding_three_elements_and_removing_one_leaves_the_two_other_in_sum() {
        list.add(3);
        list.add(17);
        list.add(.5);
        list.remove(1);
        assertEquals(3.5, list.sum());
    }

    @Test
    void getting_beyond_the_end_of_the_list_throws() {
        list.add(3);
        list.add(.5);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(2));
    }

    @Test
    void removing_beyond_the_end_of_the_list_throws() {
        list.add(3);
        list.add(.5);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.remove(2));
    }

    @Test
    void getting_before_the_beginning_of_the_list_throws() {
        list.add(3);
        list.add(.5);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    void removing_before_the_beginning_of_the_list_throws() {
        list.add(3);
        list.add(.5);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    void closest_to_zero_on_empty_list_throws_illegal_state_exception() {
        assertThrows(IllegalStateException.class, () -> list.closestToZero());
    }

    @Test
    void closest_to_zero_with_one_element_returns_that_element() {
        list.add(3);
        assertEquals(3, list.closestToZero());
    }

    @Test
    void closest_to_zero_with_several_positive_elements_returns_smallest_element() {
        list.add(5);
        list.add(3);
        list.add(8);
        assertEquals(3, list.closestToZero());
    }

    @Test
    void closest_to_zero_with_several_negative_elements_returns_largest_element() {
        list.add(-5);
        list.add(-3);
        list.add(-8);
        assertEquals(-3, list.closestToZero());
    }

    @Test
    void closest_to_zero_with_positive_and_negative_elements_returns_smallest_absolute_element() {
        list.add(-5);
        list.add(3);
        list.add(-8);
        assertEquals(3, list.closestToZero());
    }
}
