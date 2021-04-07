package seedu.duke.logic.commands;

import seedu.duke.model.TrackingList;

/**
 * Lists all the person in the tracking list to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND = "listall";

    /**
     * Executes the ListCommand.
     *
     * @param trackingList list of visitors
     * @return the list of visitors who have checked in and checked out
     */
    @Override
    public CommandOutput execute(TrackingList trackingList) {
        return new CommandOutput(trackingList.listPerson(), COMMAND);
    }

}
