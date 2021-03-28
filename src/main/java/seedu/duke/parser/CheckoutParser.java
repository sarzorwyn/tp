package seedu.duke.parser;

import seedu.duke.commands.CheckoutCommand;
import seedu.duke.commands.Command;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.NoArgumentPassedException;
import seedu.duke.exceptions.WrongFlagException;

public class CheckoutParser extends Parser {

    public static Command parseCheckOut(String argument) throws NoArgumentPassedException, WrongFlagException {
        String [] checkoutDetails;
        String id;
        String name = null;
        if (argument.isBlank()) {
            throw new NoArgumentPassedException(Messages.NO_ARGUMENT);
        } else if (idFlagChecker(argument) == -1) {
            throw new WrongFlagException(Messages.WRONG_FLAG);
        }

        if (nameFlagChecker(argument) == -1) {
            checkoutDetails = argument.split("i/",2);
        } else {
            checkoutDetails = argument.split("i/|n/",3);
        }

        if (checkoutDetails[1].isBlank()) {
            throw new NoArgumentPassedException(Messages.NO_ARGUMENT);
        } else {
            id = checkoutDetails[1].trim();
        }
        if (checkoutDetails.length == 3) {
            name = checkoutDetails[1].trim();
            id = checkoutDetails[2].trim();
        }
        return new CheckoutCommand(id,name);
    }
}
