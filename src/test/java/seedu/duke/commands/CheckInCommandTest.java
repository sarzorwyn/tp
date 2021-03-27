package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.person.PersonLog;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.testutil.SamplePersons.ALICE;
import static seedu.duke.testutil.SamplePersons.JACK_NO_PHONE;
import static seedu.duke.testutil.SamplePersons.JOHN;
import static seedu.duke.testutil.SamplePersons.JOHN_DIFF_ID;
import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class CheckInCommandTest {

    @Test
    public void testCheckInWithNameIdPhone() throws StorageOperationException, PersonNotFoundException {
        CheckInCommand checkin = new CheckInCommand(JOHN.getId().toString(), JOHN.getName().toString(),
                JOHN.getPhone().toString());
        checkin.execute(SAMPLE_TRACKING_LIST);
        assertTrue(checkin.getToCheckIn().getCheckedIn());
    }

    @Test
    public void testCheckInWithNoPhone() throws StorageOperationException, PersonNotFoundException {
        CheckInCommand checkin = new CheckInCommand(JACK_NO_PHONE.getId().toString(),
                JACK_NO_PHONE.getName().toString(), JACK_NO_PHONE.getPhone().toString());
        checkin.execute(SAMPLE_TRACKING_LIST);
        assertTrue(checkin.getToCheckIn().getCheckedIn());
    }

    @Test
    public void testCheckInWithSameNameDifferentId() throws StorageOperationException, PersonNotFoundException {
        CheckInCommand checkin = new CheckInCommand(JOHN_DIFF_ID.getId().toString(),
                JOHN_DIFF_ID.getName().toString(), JOHN_DIFF_ID.getPhone().toString());
        checkin.execute(SAMPLE_TRACKING_LIST);
        assertTrue(checkin.getToCheckIn().getCheckedIn());
    }

    @Test
    public void testCheckInForReturningVisitor() throws StorageOperationException, PersonNotFoundException {
        PersonLog personLogTest = PersonLog.getInstance();
        personLogTest.addPerson(ALICE);
        ALICE.setCheckedIn(false);
        CheckInCommand checkin = new CheckInCommand(ALICE.getId().getIdString(), null, null);
        checkin.execute(SAMPLE_TRACKING_LIST);
        assertTrue(checkin.getToCheckIn().getCheckedIn());
    }

}
