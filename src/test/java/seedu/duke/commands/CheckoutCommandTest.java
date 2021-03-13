package seedu.duke.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.duke.testutil.SamplePersons.JOHN;

public class CheckoutCommandTest {

    @Test
    public void testCheckoutCommand() {
        CheckoutCommand checkout1 = new CheckoutCommand("123A","JOHN");

        checkout1.setToCheckout(JOHN);

        checkout1.getToCheckout().setCheckedIn(false);

        assertFalse(checkout1.getToCheckout().getCheckedIn());
    }

}
