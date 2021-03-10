package seedu.duke.parser;

import seedu.duke.commands.CheckInCommand;
import seedu.duke.commands.CheckoutCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.DeleteCommand;
import seedu.duke.commands.ExitCommand;
import seedu.duke.commands.FindCommand;
import seedu.duke.commands.ListCommand;


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

    public Command parseCommand(String userInput) {
        String[] inputArray = null;
        String command = null;
        String argument = null;
        try {
            inputArray = splitTextIntoTwoFields(userInput);
            command = inputArray[0];
            argument = inputArray[1];
        } catch (Exception e) {
            System.out.println(":)");
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
        case DeleteCommand.COMMAND:
            return parseDelete();
        case ExitCommand.COMMAND:
            return parseExit();
        default:
            return null;
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

    private Command parseFind(String argument) {
        String[] findDetails = argument.split("i/",2);
        String id = findDetails[1];
        String name = findDetails[0].substring(2); //starts from index 1 due to inclusion of "/n" flag

        return new FindCommand(id);
    }

    private Command parseCheckOut(String argument) {
        String[] checkoutDetails = argument.split("i/",2);
        String id = checkoutDetails[1];
        String name = checkoutDetails[0].substring(2); //starts from index 1 due to inclusion of "/n" flag

        return new CheckoutCommand(id);
    }

    private Command parseCheckIn(String argument) {
        String[] checkInDetails = argument.split("i/",2);
        String id = checkInDetails[1];
        String name = checkInDetails[0].substring(2); //starts from index 1 due to inclusion of "/n" flag

        return new CheckInCommand(id, name, null);
    }

    //    private String parseId(String argument) {
    //        String[] details = argument.split("i/",2);
    //        return details[0];
    //    }

}
