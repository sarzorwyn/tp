package seedu.duke.logic.parser;

import seedu.duke.logic.commands.Command;
import seedu.duke.logic.commands.ListCommand;

public class ListAllParser extends Parser {
    /**
     * Parses user input and calls ListCommand to list everyone
     * who is both checked in and checked out in the storage file.
     * @return Returns ListCommand.
     */
    protected static Command parseList() {
        return new ListCommand();
    }
}
