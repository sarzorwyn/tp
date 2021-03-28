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
    public void parseCheckIn_noName() {
        Throwable exception = assertThrows(NoArgumentPassedException.class, () ->
                 CheckInParser.parseCheckIn(""));
        assertEquals(exception.getMessage(), Messages.NO_ARGUMENT);

    }

    @Test
    public void parseCheckIn_Exceptions() {
        Throwable exception = assertThrows(InvalidIdException.class, () ->
                CheckInParser.parseCheckIn("i/John 123"));
        assertEquals(exception.getMessage(), Messages.ID_ERROR);

        exception = assertThrows(NoArgumentPassedException.class, () ->
                CheckInParser.parseCheckIn(""));
        assertEquals(exception.getMessage(), Messages.NO_ARGUMENT);
    }

    @Test
    public void parseCheckIn_testCommand() throws NoArgumentPassedException,

            WrongFlagException, InvalidCommandException,
            InvalidIdException, InvalidPhoneNumberException, InvalidNameFormatException,
            StorageOperationException, InvalidIntegerException, PersonNotFoundException {

        CheckInCommand checkInCommand = (CheckInCommand) parser.parseCommand(
                "checkin i/ 123A n/ John");
        assertEquals("checkin", checkInCommand.COMMAND);

        checkInCommand = (CheckInCommand) parser.parseCommand(
                "checkin i/123A n/John p/12345678");
        assertEquals("checkin", checkInCommand.COMMAND);
    }

    @Test
    public void parseCheckOut_Exceptions() {
        Throwable exception = assertThrows(NoArgumentPassedException.class, () ->
                CheckoutParser.parseCheckOut(""));
        assertEquals(exception.getMessage(), Messages.NO_ARGUMENT);

    }

    @Test
    public void parseCheckOut_testCommand() throws NoArgumentPassedException,

            WrongFlagException, InvalidCommandException,
            InvalidIdException, InvalidPhoneNumberException, InvalidNameFormatException,
            StorageOperationException, InvalidIntegerException, PersonNotFoundException {

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
                FindParser.parseFind(""));
        assertEquals(exception.getMessage(), Messages.WRONG_FLAG);
    }

    @Test
    public void parseFind_testCommand() throws NoArgumentPassedException,

            WrongFlagException, InvalidCommandException, InvalidIdException,
            InvalidPhoneNumberException, InvalidNameFormatException,
            StorageOperationException, InvalidIntegerException, PersonNotFoundException {

        parser.parseCommand("checkin i/123A n/John");
        FindCommand findCommand = (FindCommand) parser.parseCommand("find i/123A");
        assertEquals("find", findCommand.COMMAND);
    }

    @Test
    public void parseList_testCommand() throws NoArgumentPassedException,

            WrongFlagException, InvalidCommandException, InvalidIdException,
            InvalidPhoneNumberException, InvalidNameFormatException,
            StorageOperationException, InvalidIntegerException, PersonNotFoundException {

        ListCommand listCommand = (ListCommand) parser.parseCommand("listall");
        assertEquals("listall", listCommand.COMMAND);
    }

    @Test
    public void parseListCheckedOut_testCommand() throws NoArgumentPassedException,

            WrongFlagException, InvalidCommandException, InvalidIdException,
            InvalidPhoneNumberException, InvalidNameFormatException,
            StorageOperationException, InvalidIntegerException, PersonNotFoundException {

        ListCheckedInCommand listCheckedInCommand = (ListCheckedInCommand) parser.parseCommand(
                "list");
        assertEquals("list", listCheckedInCommand.COMMAND);
    }

    @Test
    public void parseExit_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException, InvalidIdException,
            InvalidPhoneNumberException, InvalidNameFormatException,
            StorageOperationException, InvalidIntegerException, PersonNotFoundException {

        ExitCommand exitCommand = (ExitCommand) parser.parseCommand("exit");
        assertEquals("exit", exitCommand.COMMAND);
    }

    @Test
    public void parseHelp_testCommand() throws StorageOperationException, InvalidIntegerException,
            InvalidIdException, InvalidCommandException, InvalidPhoneNumberException, PersonNotFoundException,
            NoArgumentPassedException, WrongFlagException, InvalidNameFormatException {
        HelpCommand helpCommand = (HelpCommand) parser.parseCommand("help");
        assertEquals("help",helpCommand.COMMAND);
    }

    @Test
    public void parseEditMax_testCommand() throws StorageOperationException, InvalidIntegerException,
            InvalidIdException, InvalidCommandException, InvalidPhoneNumberException,
            PersonNotFoundException, NoArgumentPassedException, WrongFlagException,
            InvalidNameFormatException {
        EditMaxCommand editMaxCommand = (EditMaxCommand) parser.parseCommand("editmax 1000");
        assertEquals("editmax",editMaxCommand.COMMAND);
    }

    @Test
    public void parseMoveStorageCommand_testCommand() throws StorageOperationException, InvalidIntegerException,
            InvalidIdException, InvalidCommandException, InvalidPhoneNumberException,
            PersonNotFoundException, NoArgumentPassedException, WrongFlagException, InvalidNameFormatException {
        MoveStorageCommand moveStorageCommand = (MoveStorageCommand) parser.parseCommand("movestorage abc");
        assertEquals("movestorage",moveStorageCommand.COMMAND);
    }

    @Test
    public void parseClear_testCommand() throws NoArgumentPassedException,

            WrongFlagException, InvalidCommandException, InvalidIdException,
            InvalidPhoneNumberException, InvalidNameFormatException,
            StorageOperationException, InvalidIntegerException, PersonNotFoundException {

        ClearCommand clearCommand = (ClearCommand) parser.parseCommand("clear");
        assertEquals("clear", ClearCommand.COMMAND);
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
