package seedu.duke.commands;

/**
 * Finds the person in tracking list using id.
 */
public class FindCommand extends Command {

    public static final String COMMAND = "find";
    private final Id idKeyword;

    public FindCommand(String idKeyword) {
        this.idKeyword = new Id(idKeyword);
    }

    @Override
    public CommandOutput execute() {
        return trackingList.findPerson(idKeyword);
    }

}
