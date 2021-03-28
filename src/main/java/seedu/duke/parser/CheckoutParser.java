package seedu.duke.parser;

import seedu.duke.commands.CheckoutCommand;
import seedu.duke.commands.Command;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidIdException;
import seedu.duke.exceptions.InvalidNameFormatException;
import seedu.duke.exceptions.NoArgumentPassedException;
import seedu.duke.exceptions.WrongFlagException;
import seedu.duke.person.Id;
import seedu.duke.person.Name;

public class CheckoutParser extends Parser {

    public static Command parseCheckOut(String argument) throws NoArgumentPassedException,
            WrongFlagException, InvalidIdException {
        String [] checkoutDetails;
        String id;

        if (argument.isBlank()) {
            throw new NoArgumentPassedException(Messages.NO_ARGUMENT);
        } else if (idFlagChecker(argument) == -1) {
            throw new WrongFlagException(Messages.WRONG_FLAG);
        }


        checkoutDetails = argument.split("i/",2);

        String name = null;
        if (checkoutDetails[1].isBlank()) {
            throw new NoArgumentPassedException(Messages.NO_ARGUMENT);
        } else {
            id = checkoutDetails[1].trim();
        }


        if (!Id.isValidId(id)) {
            throw new InvalidIdException(Messages.ID_ERROR);
        }

        return new CheckoutCommand(id,name);
    }
}
