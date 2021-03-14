package seedu.duke.commands;


import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.person.Id;
import seedu.duke.person.Name;
import seedu.duke.person.Person;
import seedu.duke.person.TrackingList;


/**
 * Check-out a person.
 */
public class CheckoutCommand extends Command {

    public static final String COMMAND = "checkout";
    public static final String CHECKOUT_MESSAGE = "%s has been successfully checked-out!";

    private final Id id;
    private final Name name;
    private Person toCheckout;

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
        assert toCheckout.getName() == name : "name does not match id";
        if (toCheckout == null) {
            throw new PersonNotFoundException();
        }
        toCheckout.setCheckedIn(false);
        return new CommandOutput(String.format(CHECKOUT_MESSAGE, toCheckout.getName()), COMMAND);
    }

}
