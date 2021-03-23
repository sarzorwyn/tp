package seedu.duke.commands;

import seedu.duke.Duke;
import seedu.duke.person.TrackingList;

/**
 * Set a new maximum capacity of the location.
 */
public class EditMaxCommand extends Command {

    public static final String COMMAND = "editmax";
    public static final String EDIT_MAX_MESSAGE = "Max capacity: %d";

    private final int newMaxCapacity;

    public EditMaxCommand(int newMaxCapacity) {
        this.newMaxCapacity = newMaxCapacity;
    }

    @Override
    public CommandOutput execute(TrackingList trackingList) {
        Duke.location.setMaxCapacity(newMaxCapacity);
        return new CommandOutput(String.format(EDIT_MAX_MESSAGE, newMaxCapacity), COMMAND);
    }

}
