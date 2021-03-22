package seedu.duke.exceptions;

/**
 * Indicates that there has been an error when converting data or read/write between the application
 * and the storage file.
 */
public class StorageOperationException extends Exception {

    public StorageOperationException(String message) {
        super(message);
    }

}
