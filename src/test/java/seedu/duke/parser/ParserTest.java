package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.commands.CheckInCommand;
import seedu.duke.commands.CheckoutCommand;
import seedu.duke.commands.ClearCommand;
import seedu.duke.commands.EditMaxCommand;
import seedu.duke.commands.ExitCommand;
import seedu.duke.commands.FindCommand;
import seedu.duke.commands.HelpCommand;
import seedu.duke.commands.ListCheckedInCommand;
import seedu.duke.commands.ListCommand;
import seedu.duke.commands.MoveStorageCommand;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidIdException;
import seedu.duke.exceptions.InvalidIntegerException;
import seedu.duke.exceptions.InvalidNameFormatException;
import seedu.duke.exceptions.InvalidPhoneNumberException;
import seedu.duke.exceptions.NoArgumentPassedException;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.exceptions.WrongFlagException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.duke.testutil.SamplePersons.JOHN;

public class ParserTest {

    Parser parser = new Parser();

    @Test
    public void checkInParser_parsedCorrectly() {
        String name = JOHN.getName().getNameString().toLowerCase();
        String id = JOHN.getId().getIdString();
        String[] result = {name,id};

        assertArrayEquals(parser.splitTextIntoTwoFields("John 123A"), result);

    }

    @Test
    public void parseCommand_checker() {
        Throwable exception = assertThrows(InvalidCommandException.class, () ->
                parser.parseCommand("checkin"));
        assertEquals(exception.getMessage(), Messages.INVALID_COMMAND);
    }

    @Test
    public void parseWrongCommand_Exception() {
        Throwable exception = assertThrows(InvalidCommandException.class, () ->
                parser.parseCommand(""));
        assertEquals(exception.getMessage(), Messages.INVALID_COMMAND);
    }

    @Test
    public void parseInvalidCommand_Exception() {
        Throwable exception = assertThrows(InvalidCommandException.class, () ->
                parser.parseCommand("abc abc"));
        assertEquals(exception.getMessage(), Messages.INVALID_COMMAND);
    }

    @Test
    public void parseInvalidInteger_Exception() {

        assertFalse(parser.isValidInteger("abc"));
    }

    
}
