package seedu.duke.commands;

/**
 * Check-out a person.
 */
public class CheckoutCommand extends Command {

    public static final String COMMAND = "checkout";
    public static final String CHECKOUT_MESSAGE = "%s has been successfully checked-out!";
    private final Person toCheckout;

    public CheckoutCommand(String id) {
        toCheckout = trackingList.findPerson(id);
    }

    public Person getToCheckout() {
        return toCheckout;
    }

    @Override
    public CommandOutput execute() {
        toCheckout.setCheckin(false);
        return new CommandOutput(String.format(CHECKOUT_MESSAGE, toCheckout));
    }

}
