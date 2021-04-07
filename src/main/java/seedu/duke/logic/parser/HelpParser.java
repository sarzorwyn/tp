package seedu.duke.logic.parser;

import seedu.duke.logic.commands.Command;
import seedu.duke.logic.commands.HelpCommand;

public class HelpParser {
    /**
     * Parses user input and returns a help menu.
     * @return Returns HelpCommand
     */
    protected static Command parseHelp() {
        return new HelpCommand();
    }
}
