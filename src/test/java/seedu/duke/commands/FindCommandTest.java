package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.PersonNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class FindCommandTest {

    @Test
    public void testFind() throws PersonNotFoundException {
        FindCommand find = new FindCommand("665B");
        String foundPersonName = find.execute(SAMPLE_TRACKING_LIST).person.getName().nameString;
        assertEquals("Alice", foundPersonName);
    }

    @Test
    public void testFindPersonNotFound() {
        FindCommand find = new FindCommand("230C");
        Throwable exception = assertThrows(PersonNotFoundException.class, () ->
                find.execute(SAMPLE_TRACKING_LIST));
        assertEquals(Messages.PERSON_NOT_FOUND, exception.getMessage());
    }

}
