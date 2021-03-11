package seedu.duke.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.testutil.SamplePersons.JOHN;
import static seedu.duke.testutil.SamplePersons.ALICE;
import static seedu.duke.testutil.SamplePersons.BOB;
import static seedu.duke.testutil.SamplePersons.MARY;

public class TrackingListTest {
    private TrackingList trackingList;

    @Test
    void testConstructor() {
        trackingList = new TrackingList(JOHN, MARY, ALICE);
        assertTrue(trackingList.contains(JOHN));
        assertTrue(trackingList.contains(MARY));
        assertTrue(trackingList.contains(ALICE));
        assertFalse(trackingList.contains(BOB));
    }
}
