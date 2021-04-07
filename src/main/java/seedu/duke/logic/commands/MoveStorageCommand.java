package seedu.duke.logic.commands;

import seedu.duke.Main;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.model.TrackingList;
import seedu.duke.storage.StorageFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Moves the storage file to another location in the user's computer.
 */
public class MoveStorageCommand extends Command {

    public static final String COMMAND = "movestorage";
    public static final String TXT_FILE_FORMAT = ".txt";
    private final String newPath;
    public static final String MOVE_MESSAGE = "Moved storage file to %s.txt";

    /**
     * Creates a MoveStorageCommand to move the storage file to another location.
     *
     * @param path new location to store the storage file
     */
    public MoveStorageCommand(String path) {
        this.newPath = path;
    }

    /**
     * Executes the MoveStorageCommand.
     *
     * @param trackingList list of visitors
     * @return a success message to user
     * @throws StorageOperationException if there are problems saving into the file
     */
    @Override
    public CommandOutput execute(TrackingList trackingList) throws StorageOperationException {
        checkNewPath();

        Main main = Main.getInstance();
        StorageFile newStorage = new StorageFile(newPath);

        // Create the directory by using load
        newStorage.load();
        newStorage.save(trackingList);
        main.setStorage(newStorage);

        if (main.getConfigFile() != null) {
            moveConfigPath(main);
        }
        return new CommandOutput(String.format(MOVE_MESSAGE, newPath), COMMAND);
    }

    private void checkNewPath() throws StorageOperationException {
        try {
            if (Files.exists(Paths.get(newPath + TXT_FILE_FORMAT))) {
                throw new StorageOperationException("Destination path already exists!");
            }
        } catch (InvalidPathException ipe) {
            throw new StorageOperationException("Invalid path: " + newPath + TXT_FILE_FORMAT);
        }
    }

    private void moveConfigPath(Main main) throws StorageOperationException {
        String storageFilePath = main.getConfigFile().getStorageFilePath();

        // check not null because Paths.get() can't handle null
        if (storageFilePath != null) {
            deleteOldFile(Paths.get(storageFilePath + TXT_FILE_FORMAT));
        }
        main.getConfigFile().setStorageFilePath(newPath);
    }

    private void deleteOldFile(Path storageFilePath) throws StorageOperationException {
        try {
            Files.exists(Paths.get(storageFilePath + TXT_FILE_FORMAT));
            Files.delete(storageFilePath);
        } catch (IOException ioe) {
            throw new StorageOperationException("Unable to delete old storage file!");
        } catch (InvalidPathException ipe) {
            throw new StorageOperationException("Invalid path: " + storageFilePath + TXT_FILE_FORMAT);
        }
    }
}
