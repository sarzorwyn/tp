package seedu.duke.commands;


import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.person.Id;
import seedu.duke.person.Person;
import seedu.duke.person.TrackingList;


/**
 * Check-out a person.
 */
public class CheckoutCommand extends Command {

    public static final String COMMAND = "checkout";
    public static final String CHECKOUT_MESSAGE = "%s has been successfully checked-out!";

    private Id id;
    private Person toCheckout;

    public CheckoutCommand(String idString,String name) {
        id = new Id(idString);

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
        if (toCheckout == null) {
            throw new PersonNotFoundException();
        } else {
            toCheckout.setCheckedIn(false);
        }
        return new CommandOutput(String.format(CHECKOUT_MESSAGE, toCheckout.getName()), COMMAND);
    }

}
