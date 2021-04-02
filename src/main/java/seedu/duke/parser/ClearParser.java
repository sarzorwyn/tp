package seedu.duke.parser;

import seedu.duke.commands.ClearCommand;
import seedu.duke.commands.Command;

public class ClearParser extends Parser {
    /**
     * Parses user input and clears the list.
     * @return returns ClearCommand.
     */
    protected static Command parseClear() {
        return new ClearCommand();
    }
}
