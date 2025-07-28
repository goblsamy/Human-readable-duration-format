package hu.samy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void formatDuration() { // Az elkészített formázó függvény tesztelése különböző bemeneti értékekkel, assertEquals használatával az eredmények ellenőrzésére.
        assertEquals("now", Main.formatDuration(0));
        assertEquals("Input must be a positive integer", Main.formatDuration(-1));
        assertEquals("1 year, 1 day, 1 hour, 1 minute and 1 second", Main.formatDuration(3661 + 86400 + 31536000));
        assertEquals("2 years, 2 days, 2 hours, 2 minutes and 2 seconds", Main.formatDuration(2 * (3661 + 86400 + 31536000)));
        assertEquals("1 year, 1 day, 1 hour, 1 minute", Main.formatDuration(3660 + 86400 + 31536000));
        assertEquals("1 year, 1 day, 1 hour", Main.formatDuration(3600 + 86400 + 31536000));
        assertEquals("1 year, 1 day", Main.formatDuration(86400 + 31536000));
        assertEquals("1 year", Main.formatDuration(31536000));
        assertEquals("2 years", Main.formatDuration(2 * 31536000));
    }

}