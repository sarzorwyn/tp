package seedu.duke.commands;

/**
 * Checkin a person.
 */
public class CheckinCommand extends Command {

    public static final String COMMAND = "checkin";
    private static final Person toCheckin;

    /**
     * Checkin using raw values (first time).
     */
    public CheckinCommand(int id,
                          String name,
                          String phone,
                          Locations visitedPlaces) { // array class of visited places
        // search in the list if the person exist. if exist, use the
        // the id to get the rest of the information. else, fill up
        // everything manually.
        toCheckin = new Person(
                new Id(id),
                new Name(name),
                new Phone(phone),
                new Locations(visitedPlaces) // array class of visited places
        );
    }

    /**
     * Checkin using id (subsequent checkins).
     */
    public CheckinCommand(int id, String location) {
        toCheckin =  FindCommand.getPersonUsingId(id); // search for the person using id
        toCheckin.addLocation(location);
    }

    @Override
    public void execute() {
        trackingList.checkinPerson(toCheckin);
    }

}
