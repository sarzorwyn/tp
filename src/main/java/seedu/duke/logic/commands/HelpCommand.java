package seedu.duke.logic.commands;

import seedu.duke.model.TrackingList;

import static seedu.duke.common.Messages.CHECKIN_HELP;
import static seedu.duke.common.Messages.CHECKOUT_HELP;
import static seedu.duke.common.Messages.CLEAR_HELP;
import static seedu.duke.common.Messages.EDIT_CAPACITY_HELP;
import static seedu.duke.common.Messages.EXIT_HELP;
import static seedu.duke.common.Messages.FIND_BY_ID_HELP;
import static seedu.duke.common.Messages.LIST_ALL_HELP;
import static seedu.duke.common.Messages.LIST_CHECKED_IN_HELP;
import static seedu.duke.common.Messages.MOVE_STORAGE_HELP;
import static seedu.duke.common.Messages.USER_GUIDE_LINK_HELP;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final String COMMAND = "help";
    public static final String HELP_MESSAGE = "COMMAND SUMMARY:\n" + CHECKIN_HELP + System.lineSeparator()
            + LIST_ALL_HELP + System.lineSeparator() + LIST_CHECKED_IN_HELP + System.lineSeparator()
            + FIND_BY_ID_HELP + System.lineSeparator() + CHECKOUT_HELP + System.lineSeparator()
            + CLEAR_HELP + System.lineSeparator() + EDIT_CAPACITY_HELP + System.lineSeparator()
            + MOVE_STORAGE_HELP + System.lineSeparator() + EXIT_HELP + System.lineSeparator() + USER_GUIDE_LINK_HELP;

    /**
     * Executes the HelpCommand.
     *
     * @param trackingList list of visitors
     * @return the command summary of all the commands
     */
    @Override
    public CommandOutput execute(TrackingList trackingList) {
        return new CommandOutput(HELP_MESSAGE, COMMAND);
    }

}
