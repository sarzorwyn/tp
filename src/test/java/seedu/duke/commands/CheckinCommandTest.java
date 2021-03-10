package seedu.duke.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckinCommandTest {

    @Test
    public void testCheckinCommand() {
        CheckinCommand checkin1 = new CheckinCommand("123A", "Stark", "12345678");
        CheckinCommand checkin2 = new CheckinCommand("456B", "Rogers", null);
        CheckinCommand checkin3 = new CheckinCommand("789C", "Odinson", "87654321");

        assertTrue(checkin1.getToCheckin().getCheckin());
        assertTrue(checkin2.getToCheckin().getCheckin());
        assertTrue(checkin3.getToCheckin().getCheckin());
    }

}
