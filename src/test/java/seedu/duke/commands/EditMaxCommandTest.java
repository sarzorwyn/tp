package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.location.Location;
import seedu.duke.testutil.LocationBuilder;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class EditMaxCommandTest {

    private static final Location THEME_PARK = new LocationBuilder().withLocationName("Universal Studios Singapore")
            .withMaxCapacity(500).build();

    @Test
    public void testEditMax() {
        int currentMaxCapacity = THEME_PARK.getMaxCapacity();
        EditMaxCommand editMax = new EditMaxCommand("1000", THEME_PARK);
        editMax.execute(SAMPLE_TRACKING_LIST);
        int newMaxCapacity = THEME_PARK.getMaxCapacity();
        assertNotEquals(currentMaxCapacity, newMaxCapacity);
    }

}
