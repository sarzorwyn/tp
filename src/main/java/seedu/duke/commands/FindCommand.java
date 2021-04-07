package seedu.duke.commands;

import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.model.person.Id;
import seedu.duke.model.person.Person;
import seedu.duke.model.TrackingList;

/**
 * Finds the person in tracking list using id.
 */
public class FindCommand extends Command {

    public static final String COMMAND = "find";
    private final Id idKeyword;

    /**
     * Creates a FindCommand that finds the visitor using ID as the keyword.
     *
     * @param idKeyword ID of the visitor to be found
     */
    public FindCommand(String idKeyword) {
        this.idKeyword = new Id(idKeyword);
    }

    /**
     * Executes the FindCommand.
     *
     * @param trackingList list of visitors
     * @return the visitor as an Object
     * @throws PersonNotFoundException if a visitor of the ID provided cannot be found
     */
    @Override
    public CommandOutput execute(TrackingList trackingList) throws PersonNotFoundException {
        Person person = trackingList.findExactPerson(idKeyword);
        return new CommandOutput(person, COMMAND);
    }

}
