package seedu.duke.parser;

import seedu.duke.commands.CheckInCommand;
import seedu.duke.commands.CheckoutCommand;
import seedu.duke.commands.ClearCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.commands.FindCommand;
import seedu.duke.commands.ListCheckedInCommand;
import seedu.duke.commands.ListCommand;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.NoArgumentPassedException;
import seedu.duke.exceptions.WrongFlagException;

public class Parser {

    /**
     * Method that splits user input into 2 sections.
     * First section contains desired command
     * Second section contains the description of the task
     *
     * @param text This is the user input. It is a string
     * @return String[] This returns an array, containing 2 fields
     */
    public static String[] splitTextIntoTwoFields(String text) {
        String[] textArray = text.split(" ", 2);
        textArray[0] = textArray[0].toLowerCase();
        return textArray;
    }

    public static Command parseCommand(String userInput) throws
            InvalidCommandException, NoArgumentPassedException, WrongFlagException {
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
                && !command.equals("clear")) {
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
        default:
            throw new InvalidCommandException(Messages.INVALID_COMMAND);
        }
    }

    private static Command parseClear() {
        return new ClearCommand();
    }

    private static Command parseExit() {
        return new ExitCommand();
    }

    private static Command parseList() {
        return new ListCommand();
    }

    private static Command parseCheckedInList() {
        return new ListCheckedInCommand();
    }

    static Command parseFind(String argument) throws WrongFlagException {
        String id;
        if (argument.startsWith("i/")) {
            id = argument.substring(2);
        } else {
            throw new WrongFlagException(Messages.WRONG_FLAG);
        }
        return new FindCommand(id);
    }

    public static Command parseCheckOut(String argument) throws NoArgumentPassedException, WrongFlagException {
        String [] checkoutDetails;
        String id;
        String name = null;
        if (argument.isBlank()) {
            throw new NoArgumentPassedException(Messages.NO_ARGUMENT);
        } else if (idChecker(argument) == -1) {
            throw new WrongFlagException(Messages.WRONG_FLAG);
        }

        if (nameChecker(argument) == -1) {
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

    public static int idChecker(String argument) {
        return argument.indexOf("i/");
    }
    
    private static int nameChecker(String argument) {
        return argument.indexOf("n/");
    }
    
    private static int phoneChecker(String argument) {
        return argument.indexOf("p/");
    }
    
    static Command parseCheckIn(String argument) throws NoArgumentPassedException, WrongFlagException {
        String[] checkInDetails;
                
        if (argument.isBlank()) {
            throw new NoArgumentPassedException(Messages.NO_ARGUMENT);
        }
        assert !argument.isBlank() : "Argument cannot be blank.";
        if (idChecker(argument) == -1 || nameChecker(argument) == -1) {
            throw new WrongFlagException(Messages.WRONG_FLAG);
        }
        if (phoneChecker(argument) == -1) {
            checkInDetails = argument.split("n/|i/",3);
        } else {
            checkInDetails = argument.split("n/|i/|p/",4);
        }

        String id;
        String name;
        String phoneNumber = null;
        if (checkInDetails[1].isBlank() || checkInDetails[2].isBlank()) {     //checks if n/ and i/ is provided
            throw new NoArgumentPassedException(Messages.NO_ARGUMENT);
        } else {
            name = checkInDetails[1].trim();
            id = checkInDetails[2].trim();
        }
        if (checkInDetails.length == 4) {
            phoneNumber = checkInDetails[3].trim();
        }
        return new CheckInCommand(id, name, phoneNumber);
    }

}
