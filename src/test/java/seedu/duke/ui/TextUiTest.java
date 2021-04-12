package seedu.duke.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.model.TrackingList;
import seedu.duke.model.person.Person;

import javax.sound.midi.Track;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.testutil.SamplePersons.JOHN;
import static seedu.duke.testutil.SamplePersons.ALICE;
import static seedu.duke.testutil.SamplePersons.BOB;
import static seedu.duke.testutil.SamplePersons.MARY;
import static seedu.duke.testutil.SampleTrackingList.*;

public class TextUiTest {
    TextUi textUi = new TextUi();


    @Test
    public void testEmptyList() {
        TrackingList trackingList = new TrackingList();
        int actualCurrentCapacity = textUi.getCurrentCapacity(trackingList.listPerson());
        int expectedCurrentCapacity = 0;
        assertEquals(expectedCurrentCapacity, actualCurrentCapacity);
    }

    @Test
    public void testSampleList() {
        TrackingList trackingList = SAMPLE_TRACKING_LIST_UI;
        int actualCurrentCapacity = textUi.getCurrentCapacity(trackingList.listPerson());
        int expectedCurrentCapacity = 2;
        int wrongCurrentCapacity = 1;
        assertEquals(expectedCurrentCapacity, actualCurrentCapacity);
        assertFalse(actualCurrentCapacity == wrongCurrentCapacity);
    }

    @Test
    public void testSampleEmptyList() {
        TrackingList trackingList = SAMPLE_TRACKING_LIST_UI_ALL_CHECKED_OUT;
        int actualCurrentCapacity = textUi.getCurrentCapacity(trackingList.listPerson());
        int expectedCurrentCapacity = 0;
        assertEquals(expectedCurrentCapacity, actualCurrentCapacity);
        assertFalse(actualCurrentCapacity > 1);
    }

    @Test
    public void testSampleMixedList() {
        TrackingList trackingList = SAMPLE_TRACKING_LIST_UI_MIXED;
        int actualCurrentCapacity = textUi.getCurrentCapacity(trackingList.listPerson());
        int expectedCurrentCapacity = 2;
        assertEquals(expectedCurrentCapacity, actualCurrentCapacity);
    }

    @AfterEach
    public void clearList() {
        TrackingList trackingList = new TrackingList();
    }

}
