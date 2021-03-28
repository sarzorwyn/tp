package seedu.duke.commands;

import seedu.duke.Duke;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.HistoryStorageException;
import seedu.duke.exceptions.PersonNotFoundException;

import seedu.duke.location.Location;
import seedu.duke.person.Id;
import seedu.duke.person.Name;
import seedu.duke.person.Person;
import seedu.duke.person.TrackingList;
import seedu.duke.history.HistoryFile;

import java.util.logging.Logger;

/**
 * Check-out a person.
 */
public class CheckoutCommand extends Command {

    public static final String COMMAND = "checkout";
    private final Location location = Duke.getInstance().getLocation();
    private static int CURRENT_CAPACITY;
    private static int MAXIMUM_CAPACITY;
    public static final String CURRENT_CAPACITY_MESSAGE = "Current capacity: %d" + System.lineSeparator();
    public static final String MAXIMUM_CAPACITY_MESSAGE = "Maximum capacity: %d";
    public static final String CHECKOUT_MESSAGE = "%s has been successfully checked-out!" + System.lineSeparator();

    private final Id id;
    private String nameString;
    private Person toCheckout;
    private static final Logger logger = Logger.getLogger(CheckoutCommand.class.getName());
    private HistoryFile historyFile;

    public CheckoutCommand(String idString,String nameString) {
        this.id = new Id(idString);
        historyFile = Duke.getInstance().getHistoryFile();
        if (nameString == null) {
            this.nameString = null;
        }
        this.nameString = nameString;
    }

    public Person getToCheckout() {
        return toCheckout;
    }

    @Override
    public CommandOutput execute(TrackingList trackingList) throws PersonNotFoundException, HistoryStorageException {
        historyFile = new HistoryFile();
        toCheckout = trackingList.findExactPerson(id);
        Name toCheckoutName = toCheckout.getName();
        if (nameString != null) {
            boolean isSamePerson = toCheckoutName.getNameString().equals(nameString);
            if (!isSamePerson) {
                logger.warning("ID entered does not match the name from the list.");
            }
            assert isSamePerson : "ID does not match name.";
        }
        if (toCheckout == null) {
            throw new PersonNotFoundException(Messages.PERSON_NOT_FOUND);
        }
        toCheckout.setCheckedIn(false);
        historyFile.saveToHistory(toCheckout, " checked out at ");
        MAXIMUM_CAPACITY = location.getMaxCapacity();
        CURRENT_CAPACITY = trackingList.getCurrentCapacity();
        return new CommandOutput(String.format(CHECKOUT_MESSAGE, toCheckoutName)
                + String.format(CURRENT_CAPACITY_MESSAGE, CURRENT_CAPACITY)
                + String.format(MAXIMUM_CAPACITY_MESSAGE, MAXIMUM_CAPACITY), COMMAND);
    }

}
