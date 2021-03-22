package seedu.duke.testutil;

import seedu.duke.location.Location;

public class LocationBuilder {

    private String locationName;
    private int maxCapacity;

    public LocationBuilder withLocationName(String locationName) {
        this.locationName = locationName;
        return this;
    }

    public LocationBuilder withMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }

    public Location build() {
        return new Location(locationName, maxCapacity);
    }
}
