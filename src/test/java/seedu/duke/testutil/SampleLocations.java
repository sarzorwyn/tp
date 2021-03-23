package seedu.duke.testutil;

import seedu.duke.location.Location;

public class SampleLocations {
    public static final Location SCHOOL = new LocationBuilder().withLocationName("National University of Singapore")
            .withMaxCapacity(500).build();
    public static final Location SMALL_SHOP = new LocationBuilder().withLocationName("ValueDollar")
            .withMaxCapacity(25).build();
    public static final Location BIG_MALL = new LocationBuilder().withLocationName("VivoCity")
            .withMaxCapacity(1000).build();
    public static final Location FOOD_COURT = new LocationBuilder().withLocationName("Kopitiam")
            .withMaxCapacity(50).build();
    public static final Location CINEMA = new LocationBuilder().withLocationName("Cathay Cineplex")
            .withMaxCapacity(100).build();
    public static final Location EVENT = new LocationBuilder().withLocationName("Wedding")
            .withMaxCapacity(250).build();
}
