package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.PersonNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class FindCommandTest {

    @Test
    public void testFindNotCheckedIn() throws PersonNotFoundException {
        FindCommand find = new FindCommand("665B");
        boolean foundPersonCheckedInStatus = find.execute(SAMPLE_TRACKING_LIST).person.getCheckedIn();
        assertFalse(foundPersonCheckedInStatus);
    }

    @Test
    public void testFindCheckedIn() throws PersonNotFoundException {
        FindCommand find = new FindCommand("123A");
        boolean foundPersonCheckedInStatus = find.execute(SAMPLE_TRACKING_LIST).person.getCheckedIn();
        assertTrue(foundPersonCheckedInStatus);
    }

    @Test
    public void testFindPersonNotFound() {
        FindCommand find = new FindCommand("230C");
        Throwable exception = assertThrows(PersonNotFoundException.class, () ->
                find.execute(SAMPLE_TRACKING_LIST));
        assertEquals(Messages.PERSON_NOT_FOUND, exception.getMessage());
    }

}
