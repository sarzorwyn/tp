package seedu.duke.parser;

import seedu.duke.commands.Command;
import seedu.duke.commands.HelpCommand;

public class HelpParser {
    /**
     * Parses user input and returns a help menu.
     * @return Returns HelpCommand
     */
    protected static Command parseHelp() {
        return new HelpCommand();
    }
}
