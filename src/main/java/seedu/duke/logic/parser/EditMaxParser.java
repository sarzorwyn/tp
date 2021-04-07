package seedu.duke.logic.parser;

import seedu.duke.logic.commands.Command;
import seedu.duke.logic.commands.EditMaxCommand;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidIntegerException;
import seedu.duke.exceptions.InvalidMaxCapacityException;

/**
 * Allows user to edit maximum capacity of venue.
 */
public class EditMaxParser extends Parser {

    /**
     * Allows user to edit maximum capacity of venue.
     * @param argument Takes in new maximum capacity venue.
     * @return returns EditMaxCommand.
     * @throws InvalidIntegerException if argument is not an integer
     * @throws InvalidMaxCapacityException if argument is not a valid integer that can represent maximum capacity.
     *      EG. Negative numbers.
     */
    public static Command parseEditMax(String argument) throws InvalidIntegerException, InvalidMaxCapacityException {
        if (!isValidInteger(argument)) {
            throw new InvalidIntegerException(Messages.INVALID_INTEGER);
        }
        return new EditMaxCommand(argument);

    }
}
