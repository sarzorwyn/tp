package seedu.duke.parser;

import seedu.duke.commands.Command;
import seedu.duke.commands.EditMaxCommand;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidIntegerException;

public class EditMaxParser extends Parser {

    public static Command parseEditMax(String argument) throws InvalidIntegerException {
        if (!isValidInteger(argument)) {
            throw new InvalidIntegerException(Messages.INVALID_INTEGER);
        }
        return new EditMaxCommand(argument);

    }
}
