package seedu.duke.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.commands.CheckInCommand;
import seedu.duke.commands.CheckoutCommand;
import seedu.duke.commands.Command;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.NoArgumentPassedException;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.WrongFlagException;
import seedu.duke.person.Id;
import seedu.duke.person.Name;
import seedu.duke.person.Phone;

import java.util.Locale;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.duke.testutil.SamplePersons.JOHN;
import static seedu.duke.testutil.SamplePersons.JOHN_DIFF_ID;
import static seedu.duke.testutil.SamplePersons.JOHN_NO_PHONE;
import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class ParserTest {


    @Test
    public void checkInParser_parsedCorrectly() {
        String name = JOHN.getName().getNameString().toLowerCase();
        String id = JOHN.getId().getIdString();
        String[] result = {name,id};

        assertArrayEquals(Parser.splitTextIntoTwoFields("John 123A"), result);

    }

    @Test
    public void parseCheckIn_noName() throws WrongFlagException, NoArgumentPassedException {
        Throwable exception = assertThrows(NoArgumentPassedException.class, () ->
                Parser.parseCheckIn(""));
        assertEquals(exception.getMessage(), Messages.NO_ARGUMENT);

    }

    @Test
    public void parseCheckIn_missingFlags() {
        Throwable exception = assertThrows(WrongFlagException.class, () ->
                Parser.parseCheckIn("n/Jon 123"));
        assertEquals(exception.getMessage(), Messages.WRONG_FLAG);
    }

    @Test
    public void parseCheckIn_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        CheckInCommand checkInCommand = (CheckInCommand) Parser.parseCommand("checkin n/John i/123A");
        assertEquals("checkin", checkInCommand.COMMAND);
    }

    @Test
    public void parseCheckOut_missingFlags() {
        Throwable exception = assertThrows(NoArgumentPassedException.class, () ->
                Parser.parseCheckOut(""));
        assertEquals(exception.getMessage(), Messages.NO_ARGUMENT);
    }

    @Test
    public void parseCheckOut_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        CheckoutCommand checkoutCommand = (CheckoutCommand) Parser.parseCommand("checkout n/John i/123A");
        assertEquals("checkout", checkoutCommand.COMMAND);
    }


}
