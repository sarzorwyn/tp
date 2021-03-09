package seedu.duke.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IdTest {

    @Test
    void testEquals() {
        Id id1 = new Id("123A");
        Id id2 = new Id("123A");
        Id id3 = new Id("456B");

        assertTrue(id1.equals(id1));
        assertTrue(id1.equals(id2));
        assertFalse(id1.equals(id3));
        assertFalse(id1.equals("test string"));

    }
}
