package seedu.duke.commands;

import seedu.duke.Duke;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidMaxCapacityException;
import seedu.duke.location.Location;
import seedu.duke.person.TrackingList;

import static seedu.duke.common.Messages.INVALID_MAX_CAPACITY;

/**
 * Set a new maximum capacity of the location.
 */
public class EditMaxCommand extends Command {

    public static final String COMMAND = "editmax";
    private static final String NEW_CAPACITY_REGEX = "^[0-9]{1,6}$";
    public static final String EDIT_MAX_MESSAGE = "New max capacity: %d";

    private final int newMaxCapacity;
    private final Location location;

    public EditMaxCommand(String newMaxCapacity) throws InvalidMaxCapacityException {
        checkCapacityValidity(newMaxCapacity);
        this.newMaxCapacity = Integer.parseInt(newMaxCapacity);
        location = Duke.getInstance().getLocation();
    }

    private void checkCapacityValidity(String newMaxCapacity) throws InvalidMaxCapacityException {
        if (!newMaxCapacity.matches(NEW_CAPACITY_REGEX) || Integer.parseInt(newMaxCapacity) < 0) {
            throw new InvalidMaxCapacityException(INVALID_MAX_CAPACITY);
        }
    }

    @Override
    public CommandOutput execute(TrackingList trackingList) {
        location.setMaxCapacity(newMaxCapacity);
        return new CommandOutput(String.format(EDIT_MAX_MESSAGE, newMaxCapacity), COMMAND);
    }

}
