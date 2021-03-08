package seedu.duke.commands;

/**
 * Lists all the person in the tracking list to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND = "list";

    @Override
    public CommandOutput execute() {
        return new CommandOutput(trackingList);
    }

}
