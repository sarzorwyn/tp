package seedu.duke.commands;

import seedu.duke.Duke;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.person.TrackingList;
import seedu.duke.storage.StorageFile;

import java.nio.file.InvalidPathException;

public class MoveSaveCommand extends Command {
    public static final String COMMAND = "movesave";
    private final String newPath;
    public String MOVE_MESSAGE = "Moved saved file to %s";

    public MoveSaveCommand(String path) {
        this.newPath = path;
    }

    @Override
    public CommandOutput execute(TrackingList trackingList) throws StorageOperationException {
        StorageFile newStorage = new StorageFile(newPath);
        newStorage.save(trackingList);
        Duke.getInstance().setStorage(newStorage);

        return new CommandOutput(String.format(MOVE_MESSAGE, newPath), COMMAND);
    }
}
