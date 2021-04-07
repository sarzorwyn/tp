package seedu.duke.logic.parser;

import seedu.duke.logic.commands.ClearCommand;
import seedu.duke.logic.commands.Command;

public class ClearParser extends Parser {
    /**
     * Parses user input and clears the list.
     * @return returns ClearCommand.
     */
    protected static Command parseClear() {
        return new ClearCommand();
    }
}
