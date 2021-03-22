package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.person.Person;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class ListCommandTest {

    @Test
    public void testList() {
        ListCommand listCommand = new ListCommand();
        List<Person> list = listCommand.execute(SAMPLE_TRACKING_LIST).persons;
        assertEquals(SAMPLE_TRACKING_LIST.getSize(), list.size());
    }

}
