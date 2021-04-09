package seedu.duke.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.model.TrackingList;
import seedu.duke.model.person.Person;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.testutil.SamplePersons.ALICE;
import static seedu.duke.testutil.SamplePersons.BOB;
import static seedu.duke.testutil.SamplePersons.MARY;
import static seedu.duke.testutil.SamplePersons.JOHN;

public class TextUiTest {
    private TrackingList trackingList;


    @BeforeEach
    public void initTrackingList() {
        trackingList = new TrackingList();
    }

    @Test
    public void testGetCurrentCapacity() {
        trackingList.add(ALICE);
        trackingList.add(BOB);
        int expectedCurrentCapacity = 2;

        TextUi textUi = new TextUi();
        int actualCurrentCapacity = textUi.getCurrentCapacity(trackingList.listPerson());
        // assertEquals(expectedCurrentCapacity, actualCurrentCapacity);

        trackingList.add(MARY);
        expectedCurrentCapacity += 1;
        actualCurrentCapacity = textUi.getCurrentCapacity(trackingList.listPerson());
        assertEquals(expectedCurrentCapacity, actualCurrentCapacity);

        trackingList.clear();
        expectedCurrentCapacity = 0;
        actualCurrentCapacity = textUi.getCurrentCapacity(trackingList.listPerson());
        assertEquals(expectedCurrentCapacity, actualCurrentCapacity);
        assertFalse(actualCurrentCapacity > 1);

        trackingList.add(JOHN);
        expectedCurrentCapacity = 1;
        actualCurrentCapacity = textUi.getCurrentCapacity(trackingList.listPerson());
        assertFalse(actualCurrentCapacity == 0);
        assertEquals(expectedCurrentCapacity, actualCurrentCapacity);
        assertTrue(actualCurrentCapacity == 1);
    }

    @AfterEach
    public void clearTrackingList() {
        trackingList.clear();
    }
}
