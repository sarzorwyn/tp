package seedu.duke.parser;

import seedu.duke.commands.CheckInCommand;
import seedu.duke.commands.CheckoutCommand;
import seedu.duke.commands.ClearCommand;
import seedu.duke.commands.Command;
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
import seedu.duke.person.Id;
import seedu.duke.person.Name;
import seedu.duke.person.Phone;

public class Parser {
    public static final String MAX_REGEX = "[0-9]+";

    /**
     * Method that splits user input into 2 sections.
     * First section contains desired command
     * Second section contains the description of the task
     *
     * @param text This is the user input. It is a string
     * @return String[] This returns an array, containing 2 fields
     */
    public String[] splitTextIntoTwoFields(String text) {
        String[] textArray = text.split(" ", 2);
        textArray[0] = textArray[0].toLowerCase();
        return textArray;
    }

    public Command parseCommand(String userInput) throws

            InvalidCommandException, NoArgumentPassedException,
            WrongFlagException, InvalidIdException,
            InvalidNameFormatException, InvalidPhoneNumberException,
            StorageOperationException, InvalidIntegerException, PersonNotFoundException {

        String[] inputArray;
        String argument = null;
        assert userInput != null : "User input cannot be null";
        userInput = userInput.trim();
        inputArray = splitTextIntoTwoFields(userInput);   //inputArray may be of size 1 or size 2
        String command;
        command = inputArray[0];
        if (inputArray.length != 1) {
            argument = inputArray[1].trim();
        } else if (!command.equals("list")
                && !command.equals("exit")
                && !command.equals("listall")
                && !command.equals("clear")
                && !command.equals("help")
                && !command.equals("editmax")) {
            throw new InvalidCommandException(Messages.INVALID_COMMAND);
        }
        switch (command) {
        case CheckInCommand.COMMAND:
            return CheckInParser.parseCheckIn(argument);
        case CheckoutCommand.COMMAND:
            return CheckoutParser.parseCheckOut(argument);
        case FindCommand.COMMAND:
            return FindParser.parseFind(argument);
        case ListCommand.COMMAND:
            return ListAllParser.parseList();
        case ListCheckedInCommand.COMMAND:
            return ListCheckedInParser.parseCheckedInList();
        case ExitCommand.COMMAND:
            return ExitParser.parseExit();
        case ClearCommand.COMMAND:
            return ClearParser.parseClear();
        case HelpCommand.COMMAND:
            return HelpParser.parseHelp();
        case EditMaxCommand.COMMAND:
            return EditMaxParser.parseEditMax(argument);

        case MoveStorageCommand.COMMAND:
            return MoveStorageParser.parseMoveStorage(argument);

        default:
            throw new InvalidCommandException(Messages.INVALID_COMMAND);
        }
    }

    static boolean isValidInteger(String argument) {
        return (argument.matches(MAX_REGEX));
    }

    public static int idFlagChecker(String argument) {
        return argument.indexOf("i/");
    }
    
    protected static int nameFlagChecker(String argument) {
        return argument.indexOf("n/");
    }
    
    protected static int phoneFlagChecker(String argument) {
        return argument.indexOf("p/");
    }

}
