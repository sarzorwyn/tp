package seedu.duke.parser;

import seedu.duke.commands.Command;
import seedu.duke.commands.ListCommand;

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
