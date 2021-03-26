package seedu.duke.commands;

import seedu.duke.location.Location;
import seedu.duke.person.TrackingList;

/**
 * Set a new maximum capacity of the location.
 */
public class EditMaxCommand extends Command {

    public static final String COMMAND = "editmax";
    public static final String EDIT_MAX_MESSAGE = "New max capacity: %d";

    private final int newMaxCapacity;
    private final Location location;

    public EditMaxCommand(String newMaxCapacity, Location location) {
        this.newMaxCapacity = Integer.parseInt(newMaxCapacity);
        this.location = location;
    }

    @Override
    public CommandOutput execute(TrackingList trackingList) {
        location.setMaxCapacity(newMaxCapacity);
        return new CommandOutput(String.format(EDIT_MAX_MESSAGE, newMaxCapacity), COMMAND);
    }

}
