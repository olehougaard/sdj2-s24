package dk.via.date;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateUtilTest {
    @Test
    void year_2024_is_a_leap_year() {
        assertTrue(DateUtil.isLeapYear(2024));
    }

    @Test
    void year_2023_is_not_a_leap_year() {
        assertFalse(DateUtil.isLeapYear(2023));
    }

    @Test
    void year_2025_is_not_a_leap_year() {
        assertFalse(DateUtil.isLeapYear(2025));
    }

    @Test
    void year_2020_is_a_leap_year() {
        assertTrue(DateUtil.isLeapYear(2020));
    }

    @Test
    void year_1900_is_not_a_leap_year() {
        assertFalse(DateUtil.isLeapYear(1900));
    }

    @Test
    void year_2100_is_not_a_leap_year() {
        assertFalse(DateUtil.isLeapYear(2100));
    }

    @Test
    void year_1100_is_not_a_leap_year() {
        assertFalse(DateUtil.isLeapYear(1100));
    }

    @Test
    void year_2000_is_a_leap_year() {
        assertTrue(DateUtil.isLeapYear(2000));
    }
}
