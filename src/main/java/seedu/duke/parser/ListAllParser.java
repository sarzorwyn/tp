package seedu.duke.parser;

import seedu.duke.commands.Command;
import seedu.duke.commands.ListCommand;

public class ListAllParser extends Parser {
    protected static Command parseList() {
        return new ListCommand();
    }
}
