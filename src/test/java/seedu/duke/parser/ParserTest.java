package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.commands.CheckInCommand;
import seedu.duke.commands.CheckoutCommand;
import seedu.duke.commands.ClearCommand;
import seedu.duke.commands.ExitCommand;
import seedu.duke.commands.FindCommand;
import seedu.duke.commands.ListCheckedInCommand;
import seedu.duke.commands.ListCommand;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.NoArgumentPassedException;
import seedu.duke.exceptions.WrongFlagException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void parseCheckIn_noName() {
        Throwable exception = assertThrows(NoArgumentPassedException.class, () ->
                parser.parseCheckIn(""));
        assertEquals(exception.getMessage(), Messages.NO_ARGUMENT);

    }

    @Test
    public void parseCheckIn_Exceptions() {
        Throwable exception = assertThrows(WrongFlagException.class, () ->
                parser.parseCheckIn("n/Jon 123"));
        assertEquals(exception.getMessage(), Messages.WRONG_FLAG);

        exception = assertThrows(NoArgumentPassedException.class, () ->
                parser.parseCheckIn(""));
        assertEquals(exception.getMessage(), Messages.NO_ARGUMENT);
    }

    @Test
    public void parseCheckIn_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        CheckInCommand checkInCommand = (CheckInCommand) parser.parseCommand(
                "checkin n/ John i/ 123A");
        assertEquals("checkin", checkInCommand.COMMAND);

        checkInCommand = (CheckInCommand) parser.parseCommand(
                "checkin n/John i/123A p/12345678");
        assertEquals("checkin", checkInCommand.COMMAND);
    }

    @Test
    public void parseCheckOut_Exceptions() {
        Throwable exception = assertThrows(NoArgumentPassedException.class, () ->
                parser.parseCheckOut(""));
        assertEquals(exception.getMessage(), Messages.NO_ARGUMENT);

    }

    @Test
    public void parseCheckOut_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        CheckoutCommand checkoutCommand = (CheckoutCommand) parser.parseCommand(
                "checkout n/John i/123A");
        assertEquals("checkout", checkoutCommand.COMMAND);
        checkoutCommand = (CheckoutCommand) parser.parseCommand(
                "checkout i/123A");
        assertEquals("checkout", checkoutCommand.COMMAND);
    }

    @Test
    public void parseFindException_checker() {
        Throwable exception = assertThrows(WrongFlagException.class, () ->
                parser.parseFind(""));
        assertEquals(exception.getMessage(), Messages.WRONG_FLAG);
    }

    @Test
    public void parseFind_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        parser.parseCommand("checkin n/Jon i/123A");
        FindCommand findCommand = (FindCommand) parser.parseCommand("find i/123A");
        assertEquals("find", findCommand.COMMAND);
    }

    @Test
    public void parseList_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        ListCommand listCommand = (ListCommand) parser.parseCommand("listall");
        assertEquals("listall", listCommand.COMMAND);
    }

    @Test
    public void parseListCheckedOut_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        ListCheckedInCommand listCheckedInCommand = (ListCheckedInCommand) parser.parseCommand(
                "list");
        assertEquals("list", listCheckedInCommand.COMMAND);
    }

    @Test
    public void parseExit_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        ExitCommand exitCommand = (ExitCommand) parser.parseCommand("exit");
        assertEquals("exit", ExitCommand.COMMAND);
    }

    @Test
    public void parseClear_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        ClearCommand clearCommand = (ClearCommand) parser.parseCommand("clear");
        assertEquals("clear", ClearCommand.COMMAND);
    }

    @Test
    public void parseWrongCommand_Exception() {
        Throwable exception = assertThrows(InvalidCommandException.class, () ->
                parser.parseCommand(""));
        assertEquals(exception.getMessage(), Messages.INVALID_COMMAND);
    }
}
