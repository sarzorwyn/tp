package seedu.duke.logic.parser;

import seedu.duke.logic.commands.Command;
import seedu.duke.logic.commands.MoveStorageCommand;

public class MoveStorageParser extends Parser {
    /**
     * Parses user input and calls the MoveStorageCommand to move the storage file to another location.
     * @param argument new location to store the storage file.
     * @return returns and executes the MoveStorage command.
     */
    protected static Command parseMoveStorage(String argument) {
        return new MoveStorageCommand(argument);
    }
}
