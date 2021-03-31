package seedu.duke.commands;

import seedu.duke.person.TrackingList;

/**
 * Clears all the entries in trackingList.
 */
public class ClearCommand extends Command {

    public static final String COMMAND = "clear";
    public static final String CLEAR_MESSAGE = "Cleared %d entries";

    /**
     * Executes the ClearCommand.
     *
     * @param trackingList the list of visitors
     * @return a message to user indicating the number of entries cleared
     */
    @Override
    public CommandOutput execute(TrackingList trackingList) {
        int entriesCleared = trackingList.getSize();
        trackingList.clear();
        return new CommandOutput(String.format(CLEAR_MESSAGE, entriesCleared), COMMAND);
    }

}
