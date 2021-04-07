package seedu.duke.model.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.testutil.SamplePersons.JOHN;
import static seedu.duke.testutil.SamplePersons.JOHN_DIFF_ID;
import static seedu.duke.testutil.SamplePersons.JOHN_NO_PHONE;

public class PersonTest {

    @Test
    void testEquals() {
        assertTrue(JOHN.equals(JOHN));
        assertTrue(JOHN.equals(JOHN_NO_PHONE));
        assertFalse(JOHN.equals(JOHN_DIFF_ID));
        assertFalse(JOHN.equals("test string"));
    }
}
