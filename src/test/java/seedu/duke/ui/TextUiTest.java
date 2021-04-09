package seedu.duke.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.model.TrackingList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
        int expectedCurrentCapacity = 1;

        TextUi textUi = new TextUi();
        int actualCurrentCapacity = textUi.getCurrentCapacity(trackingList.listPerson());
        assertEquals(expectedCurrentCapacity, actualCurrentCapacity);
    }

    @AfterEach
    public void clearTrackingList() {
        trackingList.clear();
    }
}
