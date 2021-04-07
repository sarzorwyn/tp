package seedu.duke.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.logic.commands.HelpCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.logic.commands.HelpCommand.HELP_MESSAGE;
import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class HelpCommandTest {

    @Test
    public void testHelp() {
        HelpCommand help = new HelpCommand();
        String helpMessage  = help.execute(SAMPLE_TRACKING_LIST).messageToUser;
        assertEquals(HELP_MESSAGE, helpMessage);
    }

}
