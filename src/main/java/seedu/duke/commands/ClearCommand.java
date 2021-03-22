package seedu.duke.commands;

import seedu.duke.person.TrackingList;

/**
 * Clears all the entries in tracking list.
 */
public class ClearCommand extends Command {

    public static final String COMMAND = "clear";
    public static final String CLEAR_MESSAGE = "Cleared %d entries";

    @Override
    public CommandOutput execute(TrackingList trackingList) {
        int entriesCleared = trackingList.getSize();
        trackingList.clear();
        return new CommandOutput(String.format(CLEAR_MESSAGE, entriesCleared), COMMAND);
    }

}
