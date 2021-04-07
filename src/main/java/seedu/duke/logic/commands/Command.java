package seedu.duke.logic.commands;

import seedu.duke.exceptions.CheckInException;
import seedu.duke.exceptions.CheckoutException;
import seedu.duke.exceptions.HistoryStorageException;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.model.TrackingList;

/**
 * Represents an executable command.
 */
public abstract class Command {

    protected Command() {
    }

    /**
     * Executes the command.
     */
    public abstract CommandOutput execute(TrackingList trackingList) throws
            PersonNotFoundException, StorageOperationException, HistoryStorageException, CheckoutException,
            CheckInException;

}
