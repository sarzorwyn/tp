package seedu.duke.parser;

import seedu.duke.commands.Command;
import seedu.duke.commands.FindCommand;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.WrongFlagException;

public class FindParser extends Parser {
    protected static Command parseFind(String argument) throws WrongFlagException {
        String id;
        if (argument.startsWith("i/")) {
            id = argument.substring(2);
        } else {
            throw new WrongFlagException(Messages.WRONG_FLAG);
        }
        return new FindCommand(id);
    }
}
