package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.PersonNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class CheckoutCommandTest {

    @Test
    public void testCheckoutWithNameAndId() throws PersonNotFoundException {
        CheckoutCommand checkout = new CheckoutCommand("665B","Alice");
        checkout.execute(SAMPLE_TRACKING_LIST);
        assertFalse(checkout.getToCheckout().getCheckedIn());
    }

    @Test
    public void testCheckoutWithId() throws PersonNotFoundException {
        CheckoutCommand checkout = new CheckoutCommand("126C", null);
        checkout.execute(SAMPLE_TRACKING_LIST);
        assertFalse(checkout.getToCheckout().getCheckedIn());
    }

    @Test
    public void testCheckoutPersonNotFound() {
        CheckoutCommand checkout = new CheckoutCommand("230C", "Mary");
        Throwable exception = assertThrows(PersonNotFoundException.class, () ->
                checkout.execute(SAMPLE_TRACKING_LIST));
        assertEquals("Person not found!", exception.getMessage());
    }

}
