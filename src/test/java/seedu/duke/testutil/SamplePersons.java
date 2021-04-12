package seedu.duke.testutil;

import seedu.duke.model.person.Person;

public class SamplePersons {
    public static final Person ALICE = new PersonBuilder().withId("665B")
            .withName("Alice").withPhone("86862540")
            .withCheckedInStatus(true).build();
    public static final Person ALI = new PersonBuilder().withId("555B")
            .withName("Ali").withPhone("55862540")
            .withCheckedInStatus(true).build();
    public static final Person BALA = new PersonBuilder().withId("888B")
            .withName("Bala").withPhone("88888888")
            .withCheckedInStatus(true).build();
    public static final Person BOB = new PersonBuilder().withId("126C")
            .withName("Bob").withPhone("90904040")
            .withCheckedInStatus(true).build();
    public static final Person JOHN = new PersonBuilder().withId("123A")
            .withName("John").withPhone("12345678")
            .withCheckedInStatus(true).build();
    public static final Person JOHN_NO_PHONE = new PersonBuilder().withId("123A")
            .withName("John").withPhone(null)
            .withCheckedInStatus(true).build();
    public static final Person JACK_NO_PHONE = new PersonBuilder().withId("375F")
            .withName("Jack").withPhone(null)
            .withCheckedInStatus(true).build();
    public static final Person JOHN_DIFF_ID = new PersonBuilder().withId("456B")
            .withName("John").withPhone("12345678")
            .withCheckedInStatus(true).build();
    public static final Person MARY = new PersonBuilder().withId("230C")
            .withName("Mary").withPhone("95001501")
            .withCheckedInStatus(true).build();
    public static final Person NON_EXISTENT_PERSON = new PersonBuilder().withId("090S")
            .withName("Must not exist").withPhone("00000000").build();
}
