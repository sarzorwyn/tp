package seedu.duke.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class ClearCommandTest {

    @Test
    public void testClear() {
        ClearCommand clear = new ClearCommand();
        clear.execute(SAMPLE_TRACKING_LIST);
        assertEquals(0, SAMPLE_TRACKING_LIST.getSize());
    }

}
