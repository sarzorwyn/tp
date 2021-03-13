package seedu.duke.commands;

import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.person.TrackingList;

/**
 * Represents an executable command.
 */
public abstract class Command {

    protected Command() {
    }

    /**
     * Executes the command.
     */
    public CommandOutput execute(TrackingList trackingList) throws PersonNotFoundException {
        return null;
    }

}
