package seedu.duke.parser;

import seedu.duke.commands.ClearCommand;
import seedu.duke.commands.Command;

public class ClearParser extends Parser {
    protected static Command parseClear() {
        return new ClearCommand();
    }
}
