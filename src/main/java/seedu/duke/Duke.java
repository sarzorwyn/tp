package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.commands.CommandOutput;
import seedu.duke.commands.ExitCommand;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.WrongFlagException;
import seedu.duke.parser.Parser;
import seedu.duke.person.TrackingList;
import seedu.duke.ui.TextUi;

import java.util.Scanner;

public class Duke {
    private static final String VERSION_NO = "v1.0";

    /**
     * Main entry-point for the java.duke.Duke application.
     */

    public static void runUntilExit() throws InvalidCommandException, WrongFlagException, PersonNotFoundException {
        TextUi ui = new TextUi();
        Parser parser = new Parser();
        TrackingList trackingList = new TrackingList();
        Command command;
        String userInput;
        ui.showWelcomeMessage(VERSION_NO);
        do {
            userInput = ui.getUserInput();
            command = parser.parseCommand(userInput);
            CommandOutput commandOutput = command.execute(trackingList);
            ui.printReaction(commandOutput);

        } while (!(command instanceof ExitCommand));

    }

    public static void main(String[] args) throws InvalidCommandException {
        Command command = null;
        do {
            try {
                runUntilExit();
            } catch (InvalidCommandException e) {
                System.out.println("Invalid command detected. Try again!");
            } catch (PersonNotFoundException | WrongFlagException e) {
                System.out.println("Person not found!");
            }
        } while (!(command instanceof ExitCommand));


    }
}
