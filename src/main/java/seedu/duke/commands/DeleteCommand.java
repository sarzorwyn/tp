package seedu.duke.commands;

/**
 * Deletes the latest checked-in person
 * due to human error by the user.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND = "delete";
    public static final String DELETE_MESSAGE = "Deleted.";

    @Override
    public CommandOutput execute() {
        trackingList.delete(trackingList.getSize() - 1);
        return new CommandOutput(DELETE_MESSAGE);
    }

}
