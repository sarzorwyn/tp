package seedu.duke.commands;

import seedu.duke.Duke;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.person.TrackingList;
import seedu.duke.storage.StorageFile;

public class MoveStorageCommand extends Command {
    public static final String COMMAND = "movestorage";
    private final String newPath;
    public String MOVE_MESSAGE = "Moved storage file to %s.txt";

    public MoveStorageCommand(String path) {
        this.newPath = path;
    }

    @Override
    public CommandOutput execute(TrackingList trackingList) throws StorageOperationException {
        StorageFile newStorage = new StorageFile(newPath);
        StorageFile oldStorage =  Duke.getInstance().getStorage();
        TrackingList savedTrackingList = oldStorage.load();

        assert trackingList.listPerson().equals(savedTrackingList.listPerson())
                : "Saved file is desynced from actual trackingList!";

        // Create the directory by using load
        newStorage.load();
        newStorage.save(trackingList);
        Duke.getInstance().setStorage(newStorage);

        return new CommandOutput(String.format(MOVE_MESSAGE, newPath), COMMAND);
    }
}
