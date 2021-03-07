package seedu.duke.commands;

/**
 * Finds the person in tracking list using id or location.
 */
public class FindCommand extends Command {

    public static final String COMMAND = "find";
    private final String locationKeyword;

    public FindCommand(String locationKeyword) {
        this.locationKeyword = locationKeyword;
    }

    public static Person getPersonUsingId(int idKeyword) {
        Person matchedPerson = null;
        for (Person person : trackingList.getList()) {
            if (person.getId() == idKeyword) {
                matchedPerson = person;
            }
            break;
        }
        return matchedPerson;
    }

    private

    @Override
    public void execute() {
    }

}
