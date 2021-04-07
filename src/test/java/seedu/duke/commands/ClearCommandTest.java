package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.model.TrackingList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.testutil.SamplePersons.ALICE;
import static seedu.duke.testutil.SamplePersons.JOHN;
import static seedu.duke.testutil.SamplePersons.MARY;

public class ClearCommandTest {

    private final TrackingList trackingList = new TrackingList(ALICE, JOHN, MARY);

    @Test
    public void testClear() {
        ClearCommand clear = new ClearCommand();
        clear.execute(trackingList);
        assertEquals(0, trackingList.getSize());
    }

}
