package seedu.duke.testutil;

import seedu.duke.model.TrackingList;
import static seedu.duke.testutil.SamplePersons.ALICE;
import static seedu.duke.testutil.SamplePersons.BOB;
import static seedu.duke.testutil.SamplePersons.JOHN_NO_PHONE;
import static seedu.duke.testutil.SamplePersons.MARY;
import static seedu.duke.testutil.SamplePersons.ALI;
import static seedu.duke.testutil.SamplePersons.BALA;
import static seedu.duke.testutil.SamplePersons.MUTHU_CHECKED_OUT;
import static seedu.duke.testutil.SamplePersons.DAVID_CHECKED_OUT;



public class SampleTrackingList {
    public static TrackingList SAMPLE_TRACKING_LIST = new TrackingList(ALICE, BOB);
    public static TrackingList SAMPLE_STORAGE_TRACKING_LIST = new TrackingList(MARY, JOHN_NO_PHONE);
    public static TrackingList SAMPLE_TRACKING_LIST_UI = new TrackingList(ALI, BALA);
    public static TrackingList SAMPLE_TRACKING_LIST_UI_ALL_CHECKED_OUT = new TrackingList(MUTHU_CHECKED_OUT,
            DAVID_CHECKED_OUT);
    public static TrackingList SAMPLE_TRACKING_LIST_UI_MIXED = new TrackingList(ALI, BALA, MUTHU_CHECKED_OUT,
            DAVID_CHECKED_OUT);
}
