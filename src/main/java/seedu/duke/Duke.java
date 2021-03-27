package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.commands.CommandOutput;
import seedu.duke.commands.ExitCommand;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidIdException;
import seedu.duke.exceptions.InvalidIntegerException;
import seedu.duke.exceptions.InvalidNameFormatException;
import seedu.duke.exceptions.InvalidPhoneNumberException;
import seedu.duke.exceptions.NoArgumentPassedException;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.exceptions.WrongFlagException;
import seedu.duke.location.Location;
import seedu.duke.parser.Parser;
import seedu.duke.person.PersonLog;
import seedu.duke.person.TrackingList;
import seedu.duke.storage.ConfigFile;
import seedu.duke.storage.StorageFile;
import seedu.duke.ui.TextUi;


public class Duke {

    private static final String VERSION_NO = "v1.0";

    private TextUi ui;
    private Parser parser;
    private StorageFile storage;
    private TrackingList trackingList;
    private Location location;
    private PersonLog personLog;
    private ConfigFile configFile;
    private static Duke theOnlyDuke = null;

    private Duke() {
    }

    public static Duke getInstance() {
        if (theOnlyDuke == null) {
            theOnlyDuke = new Duke();
        }
        return theOnlyDuke;
    }

    public static void main(String[] args) {
        String locationName = args[0];
        int maxCapacity = Integer.parseInt(args[1]);
        getInstance().run(locationName, maxCapacity);
    }

    public void run(String locationName, int maxCapacity) {
        start(locationName, maxCapacity);
        runUntilExit();
        exit();
    }

    /** Prints Goodbye message then exists. */
    private void exit() {
        System.exit(0);
    }

    /** Main entry-point for the java.duke.Duke application. */
    private void start(String locationName, int maxCapacity) {
        location = new Location(locationName, maxCapacity);
        ui = new TextUi();
        parser = new Parser();
        personLog = PersonLog.getInstance();
        try {
            configFile = new ConfigFile();
            storage = new StorageFile(configFile.getStorageFilePath());
            trackingList = storage.load();
            personLog.loadAllPersons();
        } catch (StorageOperationException e) {
            // Shut the program down as it can not be recovered
            // throw new RuntimeException();
            ui.notifyErrorToUser(e);
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
            } catch (InvalidCommandException | NoArgumentPassedException
                    | WrongFlagException | InvalidIdException | InvalidNameFormatException
                    | InvalidPhoneNumberException | StorageOperationException
                    | InvalidIntegerException e) {

                ui.notifyErrorToUser(e);
                continue;
            }

            CommandOutput commandOutput = null;
            try {
                commandOutput = command.execute(trackingList);
                storage.save(trackingList);
                ui.printReaction(commandOutput);
            } catch (PersonNotFoundException pnfe) {
                //System.out.println("Person not found!");
                ui.notifyErrorToUser(pnfe);
                continue;
            } catch (StorageOperationException soe) {
                //System.out.println(soe.getMessage());
                ui.notifyErrorToUser(soe);
            }

        } while (!(command instanceof ExitCommand));
    }

    public Location getLocation() {
        return location;
    }

    public StorageFile getStorage() {
        return storage;
    }

    public void setStorage(StorageFile storage) {
        this.storage = storage;
    }

    public ConfigFile getConfigFile() {
        return configFile;
    }
}
