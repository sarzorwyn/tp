package seedu.duke.testutil;

import seedu.duke.model.TrackingList;
import static seedu.duke.testutil.SamplePersons.ALICE;
import static seedu.duke.testutil.SamplePersons.BOB;
import static seedu.duke.testutil.SamplePersons.JOHN_NO_PHONE;
import static seedu.duke.testutil.SamplePersons.MARY;

public class SampleTrackingList {
    public static TrackingList SAMPLE_TRACKING_LIST = new TrackingList(ALICE, BOB);
    public static TrackingList SAMPLE_STORAGE_TRACKING_LIST = new TrackingList(MARY, JOHN_NO_PHONE);
}
