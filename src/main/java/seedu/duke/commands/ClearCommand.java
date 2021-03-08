package seedu.duke.commands;

public class ClearCommand extends Command {

    public static final String COMMAND = "clear";
    public static final String CLEAR_MESSAGE = "Cleared %d entries";

    @Override
    public CommandOutput execute() {
        return new CommandOutput(String.format(CLEAR_MESSAGE, trackingList.getSize()));
    }

}
