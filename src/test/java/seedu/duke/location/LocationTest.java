package seedu.duke.location;

import org.junit.jupiter.api.Test;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidArgumentSizeException;
import seedu.duke.exceptions.InvalidMaxCapacityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.duke.testutil.SampleLocations.BIG_MALL;
import static seedu.duke.testutil.SampleLocations.EVENT;
import static seedu.duke.testutil.SampleLocations.FOOD_COURT;

public class LocationTest {
    public static final int CURRENT_CAPACITY = 20;

    @Test
    public void testInvalidArgumentSize() {
        Throwable exception = assertThrows(InvalidArgumentSizeException.class, () ->
                new Location(new String[]{"Location1", "123"}, CURRENT_CAPACITY));
        assertEquals(Messages.INVALID_ARGUMENT_SIZE, exception.getMessage());
    }

    @Test
    public void testInvalidMaxCapacity() {
        Throwable exception = assertThrows(InvalidMaxCapacityException.class, () ->
                new Location(new String[]{"Location2"}, CURRENT_CAPACITY));
        assertEquals(Messages.INVALID_MAX_CAPACITY_ARG, exception.getMessage());
    }

    @Test
    public void testGetMaxCapacity() {
        assertEquals(250, EVENT.getMaxCapacity());
        assertNotEquals(1, BIG_MALL.getMaxCapacity());
    }

    @Test
    public void testSetMaxCapacity() throws InvalidMaxCapacityException {
        int newMaxCapacity = 30;
        FOOD_COURT.setMaxCapacity(newMaxCapacity, CURRENT_CAPACITY);
        assertEquals(newMaxCapacity, FOOD_COURT.getMaxCapacity());
    }

}
