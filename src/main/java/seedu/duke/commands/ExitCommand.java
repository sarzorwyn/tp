package seedu.duke.commands;

/**
 * Terminates SET program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND = "exit";
    public static final String EXIT_MESSAGE = "Exiting Safest Entry Tracker...";

    @Override
    public CommandOutput execute() {
        return new CommandOutput(EXIT_MESSAGE);
    }

}
