package seedu.duke.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.testutil.SamplePersons.JOHN;
import static seedu.duke.testutil.SamplePersons.JOHN_DIFF_ID;
import static seedu.duke.testutil.SamplePersons.JOHN_NO_PHONE;
import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class CheckInCommandTest {

    @Test
    public void testCheckInWithNameIdPhone() {
        CheckInCommand checkin = new CheckInCommand(JOHN.getId().toString(), JOHN.getName().toString(),
                JOHN.getPhone().toString());
        checkin.execute(SAMPLE_TRACKING_LIST);
        assertTrue(checkin.getToCheckIn().getCheckedIn());
    }

    @Test
    public void testCheckInWithNoPhone() {
        CheckInCommand checkin = new CheckInCommand(JOHN_NO_PHONE.getId().toString(),
                JOHN_NO_PHONE.getName().toString(), JOHN_NO_PHONE.getPhone().toString());
        checkin.execute(SAMPLE_TRACKING_LIST);
        assertTrue(checkin.getToCheckIn().getCheckedIn());
    }

    @Test
    public void testCheckInWithSameNameDifferentId() {
        CheckInCommand checkin = new CheckInCommand(JOHN_DIFF_ID.getId().toString(),
                JOHN_DIFF_ID.getName().toString(), JOHN_DIFF_ID.getPhone().toString());
        checkin.execute(SAMPLE_TRACKING_LIST);
        assertTrue(checkin.getToCheckIn().getCheckedIn());
    }

}
