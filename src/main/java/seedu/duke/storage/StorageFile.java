package seedu.duke.storage;

import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.person.TrackingList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Manages the storing of tracking list data into a file.
 */
public class StorageFile {

    public static final String DEFAULT_STORAGE_FILEPATH = "TrackingList";
    public static final String TXT_FILE_FORMAT = ".txt";

    public static final String ID_DELIMITER = "i/";
    public static final String PHONE_ENCODED_MARKER = "p/";
    public static final String CHECKED_IN_ENCODED_MARKER = "c/";

    public static final Pattern PERSON_ENCODED_FORMAT =
            Pattern.compile("(?<name>[^/]+)"
                    + ID_DELIMITER + "(?<id>[^/]+)"
                    + PHONE_ENCODED_MARKER + "(?<phone>[^/]+)"
                    + CHECKED_IN_ENCODED_MARKER + "(?<checkedIn>[^/])");

    public Path path;

    /**
     * Creates Storage file with default path.
     */
    public StorageFile() throws InvalidPathException {
        this(DEFAULT_STORAGE_FILEPATH);
    }

    /**
     * Creates Storage file with given file path.
     * @param path The path that will be used for storage
     * @throws InvalidPathException If the path specified is invalid
     */
    public StorageFile(String path) throws InvalidPathException {
        this.path = Paths.get(path + TXT_FILE_FORMAT);
    }

    /**
     * Loads {@code TrackingList} data from this storage file and returns it.
     * @throws StorageOperationException if there were errors reading the file
     */
    public TrackingList load() throws StorageOperationException {

        // If the file does not exist, return a empty Tracking List
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            return new TrackingList();
        }

        try {
            return TrackingListDecoder.decodeTrackingList(Files.readAllLines(path));
        } catch (FileNotFoundException fnfe) {
            throw new AssertionError("A file non found scenario should have been handled before this");
        } catch (IOException ioe) {
            throw new StorageOperationException("Error writing to file: " + path);
        }
    }

    /**
     * Loads {@code TrackingList} data to this storage file.
     * @param trackingList The tracking list being saved to storage
     * @throws StorageOperationException If there is errors storing into file.
     */
    public void save(TrackingList trackingList) throws StorageOperationException {
        try {
            List<String> encodedTrackingList = TrackingListEncoder.encodeTrackingList(trackingList);
            Files.write(path, encodedTrackingList);
        } catch (IOException ioe) {
            throw new StorageOperationException("Error writing to file: " + path);
        }
    }
}
