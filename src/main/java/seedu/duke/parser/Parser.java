package seedu.duke.parser;




import seedu.duke.commands.CheckInCommand;
import seedu.duke.commands.CheckoutCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.DeleteCommand;
import seedu.duke.commands.ExitCommand;
import seedu.duke.commands.FindCommand;
import seedu.duke.commands.ListCheckedInCommand;
import seedu.duke.commands.ListCommand;
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

    public Command parseCommand(String userInput) throws
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
        } else if (!command.equals("list") && !command.equals("exit") && !command.equals("listall")) {
            throw new InvalidCommandException();
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
        case DeleteCommand.COMMAND:
            return parseDelete();
        case ExitCommand.COMMAND:
            return parseExit();
        default:
            throw new InvalidCommandException();
        }
    }



    private ExitCommand parseExit() {
        return new ExitCommand();
    }

    private Command parseDelete() {
        return new DeleteCommand();
    }

    private Command parseList() {
        return new ListCommand();
    }

    private Command parseCheckedInList() {
        return new ListCheckedInCommand();
    }

    private Command parseFind(String argument) throws WrongFlagException {
        String id;
        if (argument.startsWith("i/")) {
            id = argument.substring(2);
        } else {
            throw new WrongFlagException();
        }

        return new FindCommand(id);
    }

    private Command parseCheckOut(String argument) throws NoArgumentPassedException, WrongFlagException {
        if (argument.isBlank()) {
            throw new NoArgumentPassedException();
        }
        String[] checkoutDetails = argument.split("i/",2);
        if (checkoutDetails.length != 2) {    //checks if i/ is provided
            throw new WrongFlagException();
        }
        String id = checkoutDetails[1].trim();
        String name = "NULL";    //dummy string value since name class cannot accept null.
        if (!checkoutDetails[0].isBlank()) {
            name = checkoutDetails[0].trim().substring(2); //starts from index 1 due to inclusion of "/n" flag
        }
        return new CheckoutCommand(id,name);
    }

    private Command parseCheckIn(String argument) throws NoArgumentPassedException, WrongFlagException {
        if (argument.isBlank()) {
            throw new NoArgumentPassedException();
        }
        assert !argument.isBlank() : "Argument cannot be blank.";
        String[] checkInDetails = argument.split("i/",2);
        if (checkInDetails.length != 2) {       //checks if i/ is provided
            throw new WrongFlagException();
        }
        String id = checkInDetails[1].trim();
        String name;
        if (checkInDetails[0].isBlank()) {     //checks if n/ is provided
            throw new NoArgumentPassedException();
        } else {
            name = checkInDetails[0].trim().substring(2); //starts from index 1 due to inclusion of "/n" flag
        }
        return new CheckInCommand(id, name, null);
    }

}
