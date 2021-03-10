package seedu.duke.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckoutCommandTest {

    @Test
    public void testCheckoutCommand() {
        CheckoutCommand checkout1 = new CheckoutCommand("123A");
        CheckoutCommand checkout2 = new CheckoutCommand("456B");
        CheckoutCommand checkout3 = new CheckoutCommand("789C");

        assertFalse(checkout1.getToCheckout().getCheckedIn());
        assertFalse(checkout2.getToCheckout().getCheckedIn());
        assertFalse(checkout3.getToCheckout().getCheckedIn());
    }

}
