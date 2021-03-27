package seedu.duke.location;

import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidArgumentSizeException;
import seedu.duke.exceptions.InvalidMaxCapacityException;

public class Location {

    private String locationName;
    private int maxCapacity;
    private static final String MAX_CAPACITY_REGEX = "\\d+";

    public Location(String[] args) throws InvalidMaxCapacityException, InvalidArgumentSizeException {
        checkArgumentValidity(args);
        this.locationName = args[0];
        this.maxCapacity = Integer.parseInt(args[1]);
    }

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

    private void checkArgumentValidity(String[] args) throws InvalidArgumentSizeException, InvalidMaxCapacityException {
        if (args.length != 2) {
            throw new InvalidArgumentSizeException(Messages.INVALID_ARGUMENT_SIZE);
        }
        if (!args[1].matches(MAX_CAPACITY_REGEX)) {
            throw new InvalidMaxCapacityException(Messages.INVALID_MAX_CAPACITY);
        }
    }

}