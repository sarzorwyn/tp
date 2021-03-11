package seedu.duke.commands;

import seedu.duke.person.TrackingList;

/**
 * Lists all the person in the tracking list to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND = "list";

    @Override
    public CommandOutput execute(TrackingList trackingList) {
        return new CommandOutput(trackingList.listPerson(), COMMAND);
    }

}
