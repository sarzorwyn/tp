package seedu.duke.parser;

import seedu.duke.commands.Command;
import seedu.duke.commands.FindCommand;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidIdException;
import seedu.duke.exceptions.WrongFlagException;
import seedu.duke.person.Id;

/**
 * Finds a user and returns the user's details if user's ID is input.
 */
public class FindParser extends Parser {

    /**
     * Parses user input and finds user details.
     * @param argument ID of user.
     * @return Returns FindCommand
     * @throws WrongFlagException if ID flag is not utilised.
     */
    protected static Command parseFind(String argument) throws WrongFlagException, InvalidIdException {
        String id;
        if (argument.startsWith("i/")) {
            id = argument.substring(2);
        } else {
            throw new WrongFlagException(Messages.WRONG_FLAG);
        }


        if (!Id.isValidId(id)) {
            throw new InvalidIdException(Messages.ID_ERROR);
        }
        return new FindCommand(id);
    }
}
