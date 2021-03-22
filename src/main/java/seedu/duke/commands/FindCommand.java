package seedu.duke.commands;

import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.person.Id;
import seedu.duke.person.Person;
import seedu.duke.person.TrackingList;

/**
 * Finds the person in tracking list using id.
 * Returns if the person has checked-in or not.
 */
public class FindCommand extends Command {

    public static final String COMMAND = "find";
    public static final String CHECKED_IN_MESSAGE = "%s found is checked-in.";
    public static final String NOT_CHECKED_IN_MESSAGE = "%s found has not checked-in.";
    private final Id idKeyword;

    public FindCommand(String idKeyword) {
        this.idKeyword = new Id(idKeyword);
    }

    @Override
    public CommandOutput execute(TrackingList trackingList) throws PersonNotFoundException {
        Person person = trackingList.findExactPerson(idKeyword);
        boolean isCheckedIn = person.getCheckedIn();
        if (!isCheckedIn) {
            return new CommandOutput(person, String.format(NOT_CHECKED_IN_MESSAGE,person.getName()), COMMAND);
        }
        return new CommandOutput(person, String.format(CHECKED_IN_MESSAGE,person.getName()), COMMAND);
    }

}
