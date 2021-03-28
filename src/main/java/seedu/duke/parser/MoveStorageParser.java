package seedu.duke.parser;

import seedu.duke.commands.Command;
import seedu.duke.commands.MoveStorageCommand;

public class MoveStorageParser extends Parser {

    protected static Command parseMoveStorage(String argument) {
        return new MoveStorageCommand(argument);
    }
}
