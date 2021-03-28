//package seedu.duke.commands;
//
//import org.junit.jupiter.api.Test;
//import seedu.duke.common.Messages;
//import seedu.duke.exceptions.HistoryStorageException;
//import seedu.duke.exceptions.PersonNotFoundException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;
//
//public class CheckoutCommandTest {
//
//    @Test
//    public void testCheckoutWithId() throws PersonNotFoundException, HistoryStorageException {
//        CheckoutCommand checkout = new CheckoutCommand("126C", null);
//        checkout.execute(SAMPLE_TRACKING_LIST);
//        assertFalse(checkout.getToCheckout().getCheckedIn());
//    }
//
//    @Test
//    public void testCheckoutPersonNotFound() {
//        CheckoutCommand checkout = new CheckoutCommand("230C", "Mary");
//        Throwable exception = assertThrows(PersonNotFoundException.class, () ->
//                checkout.execute(SAMPLE_TRACKING_LIST));
//        assertEquals(Messages.PERSON_NOT_FOUND, exception.getMessage());
//    }
//
//}
