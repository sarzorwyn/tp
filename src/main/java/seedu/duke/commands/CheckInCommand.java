package seedu.duke.commands;

import seedu.duke.common.Messages;
import seedu.duke.exceptions.PersonNotFoundException;
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
    private Person toCheckin;
    private final PersonLog personLog = PersonLog.getInstance();

    public CheckInCommand(String idString,
                          String nameString,
                          String phoneString) throws StorageOperationException, PersonNotFoundException {
        Id id = new Id(idString);
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
    public CommandOutput execute(TrackingList trackingList) {
        toCheckin.setCheckedIn(true);
        if (!trackingList.contains(toCheckin)) {
            trackingList.add(toCheckin);
        }
        try {
            toCheckin = trackingList.findExactPerson(toCheckin.getId());
            toCheckin.setCheckedIn(true);
        } catch (PersonNotFoundException e) {
            System.out.println("test123");
        }
        return new CommandOutput(String.format(CHECKIN_MESSAGE, toCheckin.getName()), COMMAND);
    }

}
