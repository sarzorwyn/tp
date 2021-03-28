package seedu.duke.parser;

import seedu.duke.commands.CheckInCommand;
import seedu.duke.commands.Command;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidIdException;
import seedu.duke.exceptions.InvalidNameFormatException;
import seedu.duke.exceptions.InvalidPhoneNumberException;
import seedu.duke.exceptions.NoArgumentPassedException;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.exceptions.WrongFlagException;
import seedu.duke.person.Id;
import seedu.duke.person.Name;
import seedu.duke.person.Phone;

public class CheckInParser extends Parser {
    protected static Command parseCheckIn(String argument) throws
            NoArgumentPassedException, WrongFlagException, InvalidIdException,
            InvalidNameFormatException, InvalidPhoneNumberException,
            StorageOperationException, PersonNotFoundException {

        if (argument.isBlank()) {
            throw new NoArgumentPassedException(Messages.NO_ARGUMENT);
        }
        assert !argument.isBlank() : "Argument cannot be blank.";
        if (idFlagChecker(argument) == -1 || !argument.startsWith("i/")) {
            throw new WrongFlagException(Messages.WRONG_FLAG);
        }

        String id;
        String name = null;
        String phoneNumber = null;
        String[] checkInDetails;

        if (nameFlagChecker(argument) == -1 && phoneFlagChecker(argument) == -1) {
            checkInDetails = argument.split("i/",2);
        } else if (nameFlagChecker(argument) == -1 && phoneFlagChecker(argument) != -1) {
            throw new WrongFlagException(Messages.WRONG_FLAG);
        } else {
            checkInDetails = argument.split("i/|n/|p/",4);
        }

        if (checkInDetails[1].isBlank()) {     //checks if n/ and i/ is provided
            throw new NoArgumentPassedException(Messages.NO_ARGUMENT);
        } else {
            id = checkInDetails[1].trim();
        }
        if (checkInDetails.length == 4) {
            name = checkInDetails[2].trim();
            phoneNumber = checkInDetails[3].trim();
        } else if (checkInDetails.length == 3) {
            name = checkInDetails[2].trim();
        }

        if (!Id.isValidId(id)) {
            throw new InvalidIdException(Messages.ID_ERROR);
        }
        if (!Name.isValidName(name)) {
            throw new InvalidNameFormatException(Messages.NAME_ERROR);
        }
        if (!Phone.isValidPhone(phoneNumber)) {
            throw new InvalidPhoneNumberException(Messages.PHONE_ERROR);
        }

        return new CheckInCommand(id, name, phoneNumber);
    }
}
