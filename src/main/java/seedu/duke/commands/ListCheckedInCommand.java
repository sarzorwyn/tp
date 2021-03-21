package seedu.duke.commands;

import seedu.duke.person.TrackingList;

public class ListCheckedInCommand extends Command {

    public static final String COMMAND = "list";
    private final TrackingList checkedInList = new TrackingList();

    @Override
    public CommandOutput execute(TrackingList trackingList) {
        for (int i = 0; i < trackingList.getSize(); i++) {
            if (trackingList.getPerson(i).getCheckedIn()) {
                checkedInList.add(trackingList.getPerson(i));
            }
        }
        return new CommandOutput(checkedInList.listPerson(), COMMAND);
    }

}
