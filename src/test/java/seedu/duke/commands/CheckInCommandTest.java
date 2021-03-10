package seedu.duke.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckInCommandTest {

    @Test
    public void testCheckInCommand() {
        CheckInCommand checkin1 = new CheckInCommand("123A", "Stark", "12345678");
        CheckInCommand checkin2 = new CheckInCommand("456B", "Rogers", null);
        CheckInCommand checkin3 = new CheckInCommand("789C", "Odinson", "87654321");

        assertTrue(checkin1.getToCheckIn().getCheckedIn());
        assertTrue(checkin2.getToCheckIn().getCheckedIn());
        assertTrue(checkin3.getToCheckIn().getCheckedIn());
    }

}
