package seedu.duke.commands;

/**
 * Finds the person in tracking list using id.
 */
public class FindCommand extends Command {

    public static final String COMMAND = "find";
    private final String idKeyword;

    public FindCommand(String idKeyword) {
        this.idKeyword = idKeyword;
    }

    @Override
    public CommandOutput execute() {
        return trackingList.getPersonsUsingLocation(idKeyword);
    }

}
