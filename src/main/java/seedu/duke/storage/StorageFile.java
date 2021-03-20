package seedu.duke.storage;

import seedu.duke.person.TrackingList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StorageFile {

    public static final String DEFAULT_STORAGE_FILEPATH = "TrackingList";
    public static final String TXT_FILE_FORMAT = ".txt";

    public Path path;

    /**
     * Creates Storage file with default path
     */
    public StorageFile() throws InvalidPathException {
        this(DEFAULT_STORAGE_FILEPATH);
    }

    /**
     * Creates Storage file with given file path
     * @param path The path that will be used for storage
     * @exception InvalidPathException If the path specified is invalid
     */
    public StorageFile(String path) throws InvalidPathException {
        this.path = Paths.get(path + TXT_FILE_FORMAT);
    }

    /**
     * Loads {@code TrackingList} data from this storage file and returns it.
     *
     */
    public TrackingList load() throws StorageOperationException {

        // If the file does not exist, return a empty Tracking List
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            return new TrackingList();
        }

        try {
            return TrackingListDecoder.decodeTrackingList(Files.readAllLines(path));
        } catch (IOException ioe) {
            throw new StorageOperationException("Error writing to file: " + path);
        } catch (FileNotFoundException fnfe) {
            throw new AssertionError("A file non found scenario should have been handled before this");
        }

    }

    private class StorageOperationException extends Exception {
        public StorageOperationException(String s) {
            super(this);
        }
    }
}
