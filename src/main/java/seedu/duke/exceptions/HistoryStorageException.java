package seedu.duke.exceptions;

/**
 * Indicates that there has been an error when converting data or read/write between the application
 * and the history file.
 */
public class HistoryStorageException extends Exception {

    public HistoryStorageException(String message) {
        super(message);
    }

}
