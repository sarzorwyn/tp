package seedu.duke.commands;

import seedu.duke.person.Id;
import seedu.duke.person.Name;
import seedu.duke.person.Person;
import seedu.duke.person.Phone;
import seedu.duke.person.TrackingList;

/**
 * Check-in a person.
 */
public class CheckInCommand extends Command {

    public static final String COMMAND = "checkin";
    public static final String CHECKIN_MESSAGE = "%s has been successfully checked-in!";
    private final Person toCheckin;

    // For v2.0
    //    /**
    //     * Checkin using raw values (first time).
    //     * If already checkin, update the location list.
    //     */
    //    public CheckinCommand(String id,
    //                          String name,
    //                          String phone,
    //                          Location location) {
    //        if (trackingList.findPerson(id)) {
    //            toCheckin = trackinglist.findPerson(id);
    //            toCheckin.addLocation(location);
    //        }
    //        toCheckin = new Person(
    //                new Id(id),
    //                new Name(name),
    //                new Phone(phone),
    //                new Locations(visitedPlaces));
    //  }

    public CheckInCommand(String id,
                          String name,
                          String phone) {
        toCheckin = new Person(
                new Id(id),
                new Name(name),
                new Phone(phone));
    }

    public Person getToCheckIn() {
        return toCheckin;
    }

    @Override
    public CommandOutput execute(TrackingList trackingList) {
        toCheckin.setCheckedIn(true);
        trackingList.add(toCheckin);
        return new CommandOutput(String.format(CHECKIN_MESSAGE, toCheckin), COMMAND);
    }

}
