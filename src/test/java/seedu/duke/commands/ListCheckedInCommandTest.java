package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.person.Person;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class ListCheckedInCommandTest {

    @Test
    public void testListCheckedIn() {
        ListCheckedInCommand listCheckedIn = new ListCheckedInCommand();
        List<Person> checkedInList = listCheckedIn.execute(SAMPLE_TRACKING_LIST).persons;
        int checkedInCount = 0;
        for (Person person : SAMPLE_TRACKING_LIST.listPerson()) {
            if (person.getCheckedIn()) {
                checkedInCount++;
            }
        }
        assertEquals(checkedInCount, checkedInList.size());
    }

}
