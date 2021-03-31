package seedu.duke.commands;

import seedu.duke.person.TrackingList;

/**
 * Terminates Control Your Crowd.
 */
public class ExitCommand extends Command {

    public static final String COMMAND = "exit";
    public static final String EXIT_MESSAGE = "Exiting Control Your Crowd...";

    /**
     * Executes the ExitCommand.
     *
     * @param trackingList list of visitors
     * @return displays the exit message to the user
     */
    @Override
    public CommandOutput execute(TrackingList trackingList) {
        return new CommandOutput(EXIT_MESSAGE, COMMAND);
    }

}
