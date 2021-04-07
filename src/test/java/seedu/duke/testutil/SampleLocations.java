package seedu.duke.testutil;

import seedu.duke.exceptions.InvalidArgumentSizeException;
import seedu.duke.exceptions.InvalidMaxCapacityException;
import seedu.duke.model.Location;

public class SampleLocations {

    public static Location SCHOOL;
    public static Location SMALL_SHOP;
    public static Location BIG_MALL;
    public static Location FOOD_COURT;
    public static Location CINEMA;
    public static Location EVENT;
    public static final int CURRENT_CAPACITY = 20;

    static {
        try {
            SCHOOL = new Location(new String[] {"1000"}, CURRENT_CAPACITY);
            SMALL_SHOP = new Location(new String[] {"25"}, CURRENT_CAPACITY);
            BIG_MALL = new Location(new String[] {"1000"}, CURRENT_CAPACITY);
            FOOD_COURT = new Location(new String[] {"50"}, CURRENT_CAPACITY);
            CINEMA = new Location(new String[] {"100"}, CURRENT_CAPACITY);
            EVENT = new Location(new String[] {"250"}, CURRENT_CAPACITY);
        } catch (InvalidMaxCapacityException | InvalidArgumentSizeException e) {
            e.printStackTrace();
        }
    }
}
