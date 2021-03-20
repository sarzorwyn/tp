package seedu.duke.location;

public class Location {

    // enter locationName and set maxCapacity as arguments when running the jar file
    private String locationName;
    private int maxCapacity;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

}