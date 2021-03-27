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
            return parseCheckIn(argument);
        case CheckoutCommand.COMMAND:
            return parseCheckOut(argument);
        case FindCommand.COMMAND:
            return parseFind(argument);
        case ListCommand.COMMAND:
            return parseList();
        case ListCheckedInCommand.COMMAND:
            return parseCheckedInList();
        case ExitCommand.COMMAND:
            return parseExit();
        case ClearCommand.COMMAND:
            return parseClear();
        case HelpCommand.COMMAND:
            return parseHelp();
        case EditMaxCommand.COMMAND:
            return parseEditMax(argument);

        case MoveStorageCommand.COMMAND:
            return parseMoveStorage(argument);

        default:
            throw new InvalidCommandException(Messages.INVALID_COMMAND);
        }
    }

    boolean isValidInteger(String argument) {
        return (argument.matches(MAX_REGEX));
    }

    private Command parseEditMax(String argument) throws InvalidIntegerException {
        if (!isValidInteger(argument)) {
            throw new InvalidIntegerException(Messages.INVALID_INTEGER);
        }
        return new EditMaxCommand(argument);

    }

    private Command parseHelp() {
        return new HelpCommand();
    }

    private Command  parseMoveStorage(String argument) {
        return new MoveStorageCommand(argument);
    }


    private Command parseClear() {
        return new ClearCommand();
    }

    private Command parseExit() {
        return new ExitCommand();
    }

    private Command parseList() {
        return new ListCommand();
    }

    private Command parseCheckedInList() {
        return new ListCheckedInCommand();
    }

    Command parseFind(String argument) throws WrongFlagException {
        String id;
        if (argument.startsWith("i/")) {
            id = argument.substring(2);
        } else {
            throw new WrongFlagException(Messages.WRONG_FLAG);
        }
        return new FindCommand(id);
    }

    public Command parseCheckOut(String argument) throws NoArgumentPassedException, WrongFlagException {
        String [] checkoutDetails;
        String id;
        String name = null;
        if (argument.isBlank()) {
            throw new NoArgumentPassedException(Messages.NO_ARGUMENT);
        } else if (idFlagChecker(argument) == -1) {
            throw new WrongFlagException(Messages.WRONG_FLAG);
        }

        if (nameFlagChecker(argument) == -1) {
            checkoutDetails = argument.split("i/",2);
        } else {
            checkoutDetails = argument.split("i/|n/",3);
        }

        if (checkoutDetails[1].isBlank()) {
            throw new NoArgumentPassedException(Messages.NO_ARGUMENT);
        } else {
            id = checkoutDetails[1].trim();
        }
        if (checkoutDetails.length == 3) {
            name = checkoutDetails[1].trim();
            id = checkoutDetails[2].trim();
        }
        return new CheckoutCommand(id,name);
    }

    public int idFlagChecker(String argument) {
        return argument.indexOf("i/");
    }
    
    private int nameFlagChecker(String argument) {
        return argument.indexOf("n/");
    }
    
    private int phoneFlagChecker(String argument) {
        return argument.indexOf("p/");
    }

    Command parseCheckIn(String argument) throws
            NoArgumentPassedException, WrongFlagException, InvalidIdException,
            InvalidNameFormatException, InvalidPhoneNumberException,
            StorageOperationException, PersonNotFoundException {


                
        if (argument.isBlank()) {
            throw new NoArgumentPassedException(Messages.NO_ARGUMENT);
        }
        assert !argument.isBlank() : "Argument cannot be blank.";
        if (idFlagChecker(argument) == -1 || !argument.startsWith("i/")) {
            throw new WrongFlagException(Messages.WRONG_FLAG);
        }

        String id;
        String name = null;
        String phoneNumber = null;
        String[] checkInDetails;

        if (nameFlagChecker(argument) == -1 && phoneFlagChecker(argument) == -1) {
            checkInDetails = argument.split("i/",2);
        } else if (nameFlagChecker(argument) == -1 && phoneFlagChecker(argument) != -1) {
            throw new WrongFlagException(Messages.WRONG_FLAG);
        } else {
            checkInDetails = argument.split("i/|n/|p/",4);
        }

        if (checkInDetails[1].isBlank()) {     //checks if n/ and i/ is provided
            throw new NoArgumentPassedException(Messages.NO_ARGUMENT);
        } else {
            id = checkInDetails[1].trim();
        }
        if (checkInDetails.length == 4) {
            name = checkInDetails[2].trim();
            phoneNumber = checkInDetails[3].trim();
        } else if (checkInDetails.length == 3) {
            name = checkInDetails[2].trim();
        }

        if (!Id.isValidId(id)) {
            throw new InvalidIdException(Messages.ID_ERROR);
        }
        if (!Name.isValidName(name)) {
            throw new InvalidNameFormatException(Messages.NAME_ERROR);
        }
        if (!Phone.isValidPhone(phoneNumber)) {
            throw new InvalidPhoneNumberException(Messages.PHONE_ERROR);
        }

        return new CheckInCommand(id, name, phoneNumber);
    }

}
