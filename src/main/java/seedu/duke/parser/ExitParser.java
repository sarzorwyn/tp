package seedu.duke.parser;

import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;

public class ExitParser extends Parser {
    protected static Command parseExit() {
        return new ExitCommand();
    }
}
