package seedu.duke.commands;

import seedu.duke.Duke;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.person.TrackingList;
import seedu.duke.storage.StorageFile;

public class MoveStorageCommand extends Command {
    public static final String COMMAND = "movestorage";
    private final String newPath;
    public static final String MOVE_MESSAGE = "Moved storage file to %s.txt";

    public MoveStorageCommand(String path) {
        this.newPath = path;
    }

    @Override
    public CommandOutput execute(TrackingList trackingList) throws StorageOperationException {
        Duke duke = Duke.getInstance();
        StorageFile newStorage = new StorageFile(newPath);

        // Create the directory by using load
        newStorage.load();
        newStorage.save(trackingList);
        duke.setStorage(newStorage);

        if (duke.getConfigFile() != null) {
            duke.getConfigFile().setStorageFilePath(newPath);
        }

        return new CommandOutput(String.format(MOVE_MESSAGE, newPath), COMMAND);
    }
}
