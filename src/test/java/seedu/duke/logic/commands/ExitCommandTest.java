package seedu.duke.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.logic.commands.ExitCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static seedu.duke.logic.commands.ExitCommand.EXIT_MESSAGE;
import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class ExitCommandTest {

    @Test
    public void testExit() {
        ExitCommand exit = new ExitCommand();
        String exitMessage = exit.execute(SAMPLE_TRACKING_LIST).messageToUser;
        assertEquals(EXIT_MESSAGE, exitMessage);
    }

}
