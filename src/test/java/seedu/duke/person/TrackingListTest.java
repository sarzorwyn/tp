package seedu.duke.person;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.PersonNotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.testutil.SamplePersons.JOHN;
import static seedu.duke.testutil.SamplePersons.ALICE;
import static seedu.duke.testutil.SamplePersons.BOB;
import static seedu.duke.testutil.SamplePersons.MARY;

public class TrackingListTest {
    private TrackingList trackingList;

    @BeforeEach
    public void initTrackingList() {
        trackingList = new TrackingList();
    }

    @Test
    public void testConstructor() {
        TrackingList constructedList = new TrackingList(JOHN, MARY, ALICE);
        assertTrue(constructedList.contains(JOHN));
        assertTrue(constructedList.contains(MARY));
        assertTrue(constructedList.contains(ALICE));
        assertFalse(constructedList.contains(BOB));
    }

    @Test
    public void testContains() {
        trackingList.add(ALICE);
        trackingList.add(BOB);
        assertTrue(trackingList.contains(ALICE));
        assertFalse(trackingList.contains(JOHN));
        assertTrue(trackingList.contains(BOB));
    }

    @Test
    public void testDelete() {
        trackingList.add(ALICE);
        trackingList.add(BOB);
        trackingList.add(MARY);

        trackingList.delete(ALICE);
        int expectedBobIndex = 0;
        trackingList.delete(expectedBobIndex);

        assertFalse(trackingList.contains(ALICE));
        assertFalse(trackingList.contains(BOB));
        assertTrue(trackingList.contains(MARY));
    }

    @Test
    public void testGetPerson() {
        trackingList.add(JOHN);
        trackingList.add(MARY);
        int expectedJohnIndex = 0;

        assertEquals(JOHN,trackingList.getPerson(expectedJohnIndex));
    }

    @Test
    public void testListPerson() {
        trackingList.add(ALICE);
        trackingList.add(BOB);
        trackingList.add(MARY);

        List<Person> returnedList = trackingList.listPerson();

        assertTrue(returnedList.contains(ALICE));
        assertTrue(returnedList.contains(BOB));
        assertTrue(returnedList.contains(MARY));
    }

    @Test
    public void testGetSize() {
        int expectedSize = 0;
        assertEquals(trackingList.getSize(), expectedSize);

        trackingList.add(ALICE);
        expectedSize += 1;
        assertEquals(trackingList.getSize(), expectedSize);

        trackingList.add(BOB);
        expectedSize += 1;
        assertEquals(trackingList.getSize(), expectedSize);
    }

    @Test
    public void testClear() {
        trackingList.add(ALICE);
        trackingList.add(BOB);
        trackingList.add(MARY);

        trackingList.clear();
        assertFalse(trackingList.contains(ALICE));
        assertFalse(trackingList.contains(BOB));
        assertFalse(trackingList.contains(MARY));

        int expectedSize = 0;
        assertEquals(trackingList.getSize(), expectedSize);
    }

    @Test
    public void findExactPerson_idInTrackingList_success() throws Exception {
        trackingList.add(ALICE);
        trackingList.add(BOB);

        assertEquals(trackingList.findExactPerson(BOB.getId()), BOB);
    }

    @Test
    public void findExactPerson_idNotInTrackingList_exceptionThrown() {
        trackingList.add(ALICE);
        trackingList.add(BOB);

        assertThrows(PersonNotFoundException.class, () -> trackingList.findExactPerson(MARY.getId()));
    }

    @Test
    public void findExactPerson_phoneInTrackingList_success() throws Exception {
        trackingList.add(ALICE);
        trackingList.add(BOB);

        assertTrue(trackingList.findPerson(BOB.getPhone()).contains(BOB));
    }

    @Test
    public void findPerson_phoneNotInTrackingList_exceptionThrown() {
        trackingList.add(ALICE);
        trackingList.add(BOB);

        assertThrows(PersonNotFoundException.class, () -> trackingList.findPerson(MARY.getPhone()));
    }

    @Test
    public void findExactPerson_nameInTrackingList_success() throws Exception {
        trackingList.add(ALICE);
        trackingList.add(BOB);

        assertTrue(trackingList.findPerson(BOB.getName()).contains(BOB));
    }

    @Test
    public void findPerson_nameNotInTrackingList_exceptionThrown() {
        trackingList.add(ALICE);
        trackingList.add(BOB);

        assertThrows(PersonNotFoundException.class, () -> trackingList.findPerson(MARY.getName()));
    }

    @AfterEach
    public void clearTrackingList() {
        trackingList.clear();
    }
}
