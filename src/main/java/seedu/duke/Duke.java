package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.commands.CommandOutput;
import seedu.duke.commands.ExitCommand;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.NoArgumentPassedException;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.exceptions.WrongFlagException;
import seedu.duke.location.Location;
import seedu.duke.parser.Parser;
import seedu.duke.person.TrackingList;
import seedu.duke.storage.StorageFile;
import seedu.duke.ui.TextUi;


public class Duke {

    private static final String VERSION_NO = "v1.0";

    public static Location location;

    private TextUi ui;
    private Parser parser;
    private StorageFile storage;
    private TrackingList trackingList;

    public static void main(String[] args) {
        String locationName = args[0];
        int maxCapacity = Integer.parseInt(args[1]);
        location = new Location(locationName, maxCapacity);
        new Duke().run();
    }

    public void run() {
        start();
        runUntilExit();
        exit();
    }

    /** Prints Goodbye message then exists. */
    private void exit() {
        System.exit(0);
    }

    /** Main entry-point for the java.duke.Duke application. */
    private void start() {
        ui = new TextUi();
        parser = new Parser();
        storage = new StorageFile();
        try {
            trackingList = storage.load();
        } catch (StorageOperationException e) {
            // Shut the program down as it can not be recovered
            throw new RuntimeException();
        }
        ui.showWelcomeMessage(VERSION_NO);
    }

    /** Reads the user command and executes it, until the user issues the exit command. */
    private void runUntilExit() {
        Command command = null;
        String userInput;
        do {
            userInput = ui.getUserInput();
            try {
                command = parser.parseCommand(userInput);
            } catch (InvalidCommandException | NoArgumentPassedException | WrongFlagException e) {
                ui.notifyErrorToUser(e);
                continue;
            }

            CommandOutput commandOutput = null;
            try {
                commandOutput = command.execute(trackingList);
                storage.save(trackingList);
                ui.printReaction(commandOutput);
            } catch (PersonNotFoundException pnfe) {
                System.out.println("Person not found!");
                continue;
            } catch (StorageOperationException soe) {
                System.out.println(soe.getMessage());
            }

        } while (!(command instanceof ExitCommand));
    }

}
