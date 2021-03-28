package seedu.duke.parser;

import seedu.duke.commands.Command;
import seedu.duke.commands.HelpCommand;

public class HelpParser {

    protected static Command parseHelp() {
        return new HelpCommand();
    }
}
