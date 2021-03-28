package seedu.duke.commands;

import seedu.duke.Duke;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.HistoryStorageException;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.history.HistoryFile;
import seedu.duke.location.Location;
import seedu.duke.person.Id;
import seedu.duke.person.Name;
import seedu.duke.person.Person;
import seedu.duke.person.PersonLog;
import seedu.duke.person.Phone;
import seedu.duke.person.TrackingList;

/**
 * Check-in a person.
 */
public class CheckInCommand extends Command {

    public static final String COMMAND = "checkin";
    private final Location location = Duke.getInstance().getLocation();
    private static int CURRENT_CAPACITY;
    private static int MAXIMUM_CAPACITY;
    public static final String CHECKIN_SUCCESS_MESSAGE = "%s has been successfully checked-in!"
            + System.lineSeparator();
    public static final String CURRENT_CAPACITY_MESSAGE = "Current capacity: %d" + System.lineSeparator();
    public static final String MAXIMUM_CAPACITY_MESSAGE = "Maximum capacity: %d";
    public static final String CHECKIN_FAIL_MESSAGE = "Unable to check in! Maximum capacity of %d reached!";
    private final Person toCheckin;
    private HistoryFile historyFile;

    public CheckInCommand(String idString,
                          String nameString,
                          String phoneString) throws StorageOperationException, PersonNotFoundException {
        Id id = new Id(idString);
        historyFile = Duke.getInstance().getHistoryFile();
        PersonLog personLog = PersonLog.getInstance();
        if (personLog.isFound(id)) {
            toCheckin = personLog.findPerson(id);
            checkSameName(nameString);
        } else if (nameString == null) {
            throw new PersonNotFoundException(Messages.PERSON_NOT_FOUND);
        } else {
            toCheckin = new Person(id, new Name(nameString), new Phone(phoneString));
            personLog.addPerson(toCheckin);
        }
    }

    private void checkSameName(String nameString) throws PersonNotFoundException {
        if (nameString == null) {
            return;
        }
        if (!toCheckin.getName().toString().equals(nameString)) {
            throw new PersonNotFoundException(Messages.DIFF_NAME_SAME_ID);
        }
    }

    public Person getToCheckIn() {
        return toCheckin;
    }

    @Override
    public CommandOutput execute(TrackingList trackingList) throws HistoryStorageException, PersonNotFoundException {
        historyFile = new HistoryFile();
        MAXIMUM_CAPACITY = location.getMaxCapacity();
        if (trackingList.getCurrentCapacity() >= MAXIMUM_CAPACITY) {
            return new CommandOutput(String.format(CHECKIN_FAIL_MESSAGE, MAXIMUM_CAPACITY), COMMAND);
        }
        if (!trackingList.contains(toCheckin)) {
            toCheckin.setCheckedIn(true);
            trackingList.add(toCheckin);
        } else {
            trackingList.findExactPerson(toCheckin.getId()).setCheckedIn(true);
        }
        historyFile.saveToHistory(toCheckin, " checked in at ");
        CURRENT_CAPACITY = trackingList.getCurrentCapacity();
        return new CommandOutput(String.format(CHECKIN_SUCCESS_MESSAGE, toCheckin.getName())
                + String.format(CURRENT_CAPACITY_MESSAGE, CURRENT_CAPACITY)
                + String.format(MAXIMUM_CAPACITY_MESSAGE, MAXIMUM_CAPACITY), COMMAND);
    }

}
