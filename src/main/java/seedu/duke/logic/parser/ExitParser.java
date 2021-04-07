package seedu.duke.logic.parser;

import seedu.duke.logic.commands.Command;
import seedu.duke.logic.commands.ExitCommand;


public class ExitParser extends Parser {
    /**
     * Parses user input and exits CYC.
     * @return Returns ExitCommand.
     */
    protected static Command parseExit() {
        return new ExitCommand();
    }
}
