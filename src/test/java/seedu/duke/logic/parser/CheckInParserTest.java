package seedu.duke.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.logic.commands.CheckInCommand;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidIdException;
import seedu.duke.exceptions.InvalidIntegerException;
import seedu.duke.exceptions.InvalidMaxCapacityException;
import seedu.duke.exceptions.InvalidNameFormatException;
import seedu.duke.exceptions.InvalidPhoneNumberException;
import seedu.duke.exceptions.NoArgumentPassedException;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.exceptions.WrongFlagException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckInParserTest {

    Parser parser = new Parser();

    @Test
    public void parseCheckIn_testCommand() throws NoArgumentPassedException,

            WrongFlagException, InvalidCommandException,
            InvalidIdException, InvalidPhoneNumberException, InvalidNameFormatException,
            StorageOperationException, InvalidIntegerException, PersonNotFoundException, InvalidMaxCapacityException {

        CheckInCommand checkInCommand = (CheckInCommand) parser.parseCommand(
                "checkin i/ 123A n/ John");
        assertEquals("checkin", checkInCommand.COMMAND);

        checkInCommand = (CheckInCommand) parser.parseCommand(
                "checkin i/123A n/John p/12345678");
        assertEquals("checkin", checkInCommand.COMMAND);

        checkInCommand = (CheckInCommand) parser.parseCommand(
                "checkin i/123A p/12345678");
        assertEquals("checkin", checkInCommand.COMMAND);

    }

    @Test
    public void parseCheckIn_Exceptions() {

        Throwable exception = assertThrows(NoArgumentPassedException.class, () ->
                CheckInParser.parseCheckIn(""));
        assertEquals(exception.getMessage(), Messages.NO_ARGUMENT);

        exception = assertThrows(InvalidIdException.class, () ->
                CheckInParser.parseCheckIn("i/JOHN 123"));
        assertEquals(exception.getMessage(), Messages.ID_ERROR);

        exception = assertThrows(NoArgumentPassedException.class, () ->
                CheckInParser.parseCheckIn(""));
        assertEquals(exception.getMessage(), Messages.NO_ARGUMENT);

        exception = assertThrows(WrongFlagException.class, () ->
                CheckInParser.parseCheckIn("n/"));
        assertEquals(exception.getMessage(), Messages.WRONG_FLAG);

        exception = assertThrows(NoArgumentPassedException.class, () ->
                CheckInParser.parseCheckIn("i/"));
        assertEquals(exception.getMessage(), Messages.NO_ARGUMENT);

        exception = assertThrows(InvalidNameFormatException.class, () ->
                CheckInParser.parseCheckIn("i/123A n/123"));
        assertEquals(exception.getMessage(), Messages.NAME_ERROR);

        exception = assertThrows(InvalidPhoneNumberException.class, () ->
                CheckInParser.parseCheckIn("i/123A n/John p/123456"));
        assertEquals(exception.getMessage(), Messages.PHONE_ERROR);

        exception = assertThrows(WrongFlagException.class, () ->
                CheckInParser.parseCheckIn("m/123a"));
        assertEquals(exception.getMessage(), Messages.WRONG_FLAG);






    }
}
