package seedu.duke.parser;

import seedu.duke.commands.Command;
import seedu.duke.commands.ListCheckedInCommand;

public class ListCheckedInParser extends Parser {
    protected static Command parseCheckedInList() {
        return new ListCheckedInCommand();
    }
}
