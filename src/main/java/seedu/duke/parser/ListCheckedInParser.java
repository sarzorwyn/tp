package seedu.duke.parser;

import seedu.duke.commands.Command;
import seedu.duke.commands.ListCheckedInCommand;

public class ListCheckedInParser extends Parser {
    /**
     * Parses user input and calls ListCheckedInCommand to list all the people who are currently checked in.
     * @return Returns ListCheckedInCommand.
     */
    protected static Command parseCheckedInList() {
        return new ListCheckedInCommand();
    }
}
