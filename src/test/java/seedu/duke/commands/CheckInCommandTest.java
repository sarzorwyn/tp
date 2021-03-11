package seedu.duke.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.testutil.SamplePersons.JOHN;
import static seedu.duke.testutil.SamplePersons.JOHN_DIFF_ID;
import static seedu.duke.testutil.SamplePersons.JOHN_NO_PHONE;

public class CheckInCommandTest {

    @Test
    public void testCheckInCommand() {
        CheckInCommand checkin1 = new CheckInCommand(JOHN.getId().toString(), JOHN.getName().toString(),
                JOHN.getPhone().toString());
        CheckInCommand checkin2 = new CheckInCommand(JOHN_NO_PHONE.getId().toString(),
                JOHN_NO_PHONE.getName().toString(), JOHN_NO_PHONE.getPhone().toString());
        CheckInCommand checkin3 = new CheckInCommand(JOHN_DIFF_ID.getId().toString(),
                JOHN_DIFF_ID.getName().toString(), JOHN_DIFF_ID.getPhone().toString());

        checkin1.getToCheckIn().setCheckedIn(true);
        checkin2.getToCheckIn().setCheckedIn(true);
        checkin3.getToCheckIn().setCheckedIn(true);

        assertTrue(checkin1.getToCheckIn().getCheckedIn());
        assertTrue(checkin2.getToCheckIn().getCheckedIn());
        assertTrue(checkin3.getToCheckIn().getCheckedIn());
    }

}
