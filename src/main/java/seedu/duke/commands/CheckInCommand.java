package seedu.duke.commands;

import seedu.duke.exceptions.StorageOperationException;
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
    public static final String CHECKIN_MESSAGE = "%s has been successfully checked-in!";
    private final Person toCheckin;
    private final PersonLog personLog = PersonLog.getInstance();

    /** To check-in a person who is not found in the Person Log. */
    public CheckInCommand(String id,
                          String name,
                          String phone) throws StorageOperationException {
        toCheckin = new Person(
                new Id(id),
                new Name(name),
                new Phone(phone));
        if (!personLog.isFound(toCheckin.getId())) {
            personLog.addPerson(toCheckin);
        }
    }

    /** To check-in a person who is already in the Person Log. */
    public CheckInCommand(String id) {
        toCheckin = personLog.findPerson(new Id(id));
    }

    public Person getToCheckIn() {
        return toCheckin;
    }

    @Override
    public CommandOutput execute(TrackingList trackingList) {
        toCheckin.setCheckedIn(true);
        if (!trackingList.contains(toCheckin)) {
            trackingList.add(toCheckin);
        }
        return new CommandOutput(String.format(CHECKIN_MESSAGE, toCheckin.getName()), COMMAND);
    }

}
