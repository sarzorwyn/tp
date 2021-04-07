package seedu.duke;

import seedu.duke.logic.commands.Command;
import seedu.duke.logic.commands.CommandOutput;
import seedu.duke.logic.commands.ExitCommand;
import seedu.duke.exceptions.CheckInException;
import seedu.duke.exceptions.CheckoutException;
import seedu.duke.exceptions.HistoryStorageException;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidIdException;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.exceptions.InvalidMaxCapacityException;
import seedu.duke.exceptions.InvalidArgumentSizeException;
import seedu.duke.exceptions.NoArgumentPassedException;
import seedu.duke.exceptions.WrongFlagException;
import seedu.duke.exceptions.InvalidNameFormatException;
import seedu.duke.exceptions.InvalidPhoneNumberException;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.InvalidIntegerException;
import seedu.duke.storage.HistoryFile;
import seedu.duke.model.Location;
import seedu.duke.logic.parser.Parser;
import seedu.duke.model.PersonLog;
import seedu.duke.model.TrackingList;
import seedu.duke.storage.ConfigFile;
import seedu.duke.storage.StorageFile;
import seedu.duke.ui.TextUi;

public class Main {

    private static final String VERSION_NO = "v2.0";
    private static final String EXIT_MESSAGE = "Exiting Control Your Crowd...";

    private TextUi ui;
    private Parser parser;
    private StorageFile storage;
    private TrackingList trackingList;
    private Location location;
    private PersonLog personLog;
    private ConfigFile configFile;
    private HistoryFile historyFile;
    private static Main theOnlyMain = null;

    private Main() {
    }

    public static Main getInstance() {
        if (theOnlyMain == null) {
            theOnlyMain = new Main();
        }
        return theOnlyMain;
    }

    public static void main(String[] args) throws HistoryStorageException {
        getInstance().run(args);
    }

    /** Catches System.exit() and interrupts. Exits gracefully */
    private void exitDuke() {
        ExitCommand command = new ExitCommand();
        CommandOutput commandOutput = command.execute(trackingList);
        ui.printReaction(commandOutput);
    }

    public void run(String[] args) throws HistoryStorageException {
        Runtime.getRuntime().addShutdownHook(new Thread(this::exitDuke));
        start(args);
        runUntilExit();
        exit();
    }

    /** Prints Goodbye message then exists. */
    private void exit() throws HistoryStorageException {
        historyFile.endHistory();
        System.exit(0);
    }

    /** Main entry-point for the java.duke.Main application. */
    private void start(String[] args) {
        ui = new TextUi();
        parser = new Parser();
        personLog = PersonLog.getInstance();
        try {
            historyFile = new HistoryFile();
            configFile = new ConfigFile();
            storage = new StorageFile(configFile.getStorageFilePath());
            trackingList = storage.load();
            location = new Location(args, trackingList.getCurrentCapacity());
            personLog.loadAllPersons();
            historyFile.startHistory();
        } catch (StorageOperationException | HistoryStorageException e) {
            // Shut the program down as it can not be recovered
            // throw new RuntimeException();
            //PR testing for checks
            ui.notifyErrorToUser(e);
        } catch (InvalidMaxCapacityException | InvalidArgumentSizeException e) {
            ui.notifyErrorToUser(e);
            System.exit(0);
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
            } catch (InvalidCommandException | NoArgumentPassedException | WrongFlagException | InvalidIdException
                    | InvalidNameFormatException | InvalidPhoneNumberException | StorageOperationException
                    | InvalidIntegerException | PersonNotFoundException | InvalidMaxCapacityException e) {
                ui.notifyErrorToUser(e);
                continue;
            }

            CommandOutput commandOutput = null;
            try {
                commandOutput = command.execute(trackingList);
                storage.save(trackingList);
                personLog.saveAllPersons();
                if (command instanceof ExitCommand) {
                    break;
                }
                ui.printReaction(commandOutput);
            } catch (PersonNotFoundException | StorageOperationException | HistoryStorageException | CheckoutException
                    | CheckInException | InvalidMaxCapacityException e) {
                //System.out.println("Person not found!");
                ui.notifyErrorToUser(e);
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

    public HistoryFile getHistoryFile() {
        return historyFile;
    }
}
