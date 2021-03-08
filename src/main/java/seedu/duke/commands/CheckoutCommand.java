package seedu.duke.commands;

/**
 * Check-out a person.
 */
public class CheckoutCommand extends Command {

    public static final String COMMAND = "checkout";
    public static final String CHECKOUT_MESSAGE = "%s has been successfully checked-out!";
    private Person toCheckout;

    public CheckoutCommand(String id) {
        toCheckout = trackingList.findPerson(id);
    }

    @Override
    public CommandOutput execute() {
        toCheckout.setCheckinStatus(false);
        return new CommandOutput(String.format(CHECKOUT_MESSAGE, toCheckout));
    }

}
