package seedu.duke.commands;

import seedu.duke.person.TrackingList;

public class ListCheckedInCommand extends Command {

    public static final String COMMAND = "list";

    @Override
    public CommandOutput execute(TrackingList trackingList) {
        return new CommandOutput(trackingList.listPerson(), COMMAND);
    }
}
