package seedu.duke.commands;

import seedu.duke.exceptions.PersonNotFoundException;

import seedu.duke.person.Id;
import seedu.duke.person.Name;
import seedu.duke.person.Person;
import seedu.duke.person.TrackingList;

import java.util.logging.Logger;

/**
 * Check-out a person.
 */
public class CheckoutCommand extends Command {

    public static final String COMMAND = "checkout";
    public static final String CHECKOUT_MESSAGE = "%s has been successfully checked-out!";

    private final Id id;
    private final Name name;
    private Person toCheckout;
    private static Logger logger = Logger.getLogger(CheckoutCommand.class.getName());

    public CheckoutCommand(String idString,String nameString) {
        id = new Id(idString);
        name = new Name(nameString);
    }

    public Person getToCheckout() {
        return toCheckout;
    }

    public void setToCheckout(Person person) {
        toCheckout = person;
    }

    @Override
    public CommandOutput execute(TrackingList trackingList) throws PersonNotFoundException {
        toCheckout = trackingList.findExactPerson(id);
        Name toCheckoutName = toCheckout.getName();
        boolean isSamePerson = toCheckoutName.getNameString().equals(name.getNameString());
        if (!isSamePerson) {
            logger.warning("ID entered does not match the name from the list.");
        }
        assert isSamePerson : "ID does not match name.";
        if (toCheckout == null) {
            throw new PersonNotFoundException();
        }
        toCheckout.setCheckedIn(false);
        return new CommandOutput(String.format(CHECKOUT_MESSAGE, toCheckout.getName()), COMMAND);
    }

}
