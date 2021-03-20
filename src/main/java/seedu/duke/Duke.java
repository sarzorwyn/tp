package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.commands.CommandOutput;
import seedu.duke.commands.ExitCommand;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.NoArgumentPassedException;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.WrongFlagException;
import seedu.duke.parser.Parser;
import seedu.duke.person.TrackingList;
import seedu.duke.ui.TextUi;

import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Duke {
    private static final String VERSION_NO = "v1.0";

    /**
     * Main entry-point for the java.duke.Duke application.
     */

    public static void runUntilExit() {
        TextUi ui = new TextUi();
        Parser parser = new Parser();
        TrackingList trackingList = new TrackingList();
        Command command = null;
        String userInput;
        ui.showWelcomeMessage(VERSION_NO);
        do {
            userInput = ui.getUserInput();
            try {
                command = parser.parseCommand(userInput);
            } catch (InvalidCommandException e) {
                ui.printInvalidCommandError();
                continue;
            } catch (NoArgumentPassedException e) {
                ui.printNoArgumentError();
                continue;
            } catch (WrongFlagException e) {
                ui.printWrongFlagError();
                continue;
            }

            CommandOutput commandOutput = null;
            try {
                commandOutput = command.execute(trackingList);
            } catch (PersonNotFoundException e) {
                System.out.println("Person not found!");
                continue;
            }
            ui.printReaction(commandOutput);

        } while (!(command instanceof ExitCommand));

    }

    public static void main(String[] args) {
        runUntilExit();
    }
}
