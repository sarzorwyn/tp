package seedu.duke.commands;

import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.person.Id;
import seedu.duke.person.Person;
import seedu.duke.person.TrackingList;

/**
 * Finds the person in tracking list using id.
 */
public class FindCommand extends Command {

    public static final String COMMAND = "find";
    public static final String FIND_MESSAGE = "%s found.";
    private final Id idKeyword;

    public FindCommand(String idKeyword) {
        this.idKeyword = new Id(idKeyword);
    }

    @Override
    public CommandOutput execute(TrackingList trackingList) throws PersonNotFoundException {
        Person person = trackingList.findExactPerson(idKeyword);
        return new CommandOutput(person, String.format(FIND_MESSAGE,person.getName()), COMMAND);
    }

}
