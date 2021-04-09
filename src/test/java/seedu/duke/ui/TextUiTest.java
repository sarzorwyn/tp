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
import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class TextUiTest {
    private TrackingList trackingList;
    TextUi textUi = new TextUi();

    @Test
    public void testGetCurrentCapacity() {
        int expectedCurrentCapacity = 3;
        int actualCurrentCapacity = textUi.getCurrentCapacity(SAMPLE_TRACKING_LIST.listPerson());
        assertEquals(expectedCurrentCapacity, actualCurrentCapacity);
    }
}
