package seedu.duke.testutil;

import seedu.duke.person.Person;

public class SamplePersons {
    public static final Person JOHN = new PersonBuilder().withId("123A")
            .withName("John").withPhone("12345678")
            .withCheckedInStatus(true).build();
    public static final Person JOHN_NO_PHONE = new PersonBuilder().withId("123A")
            .withName("John").withPhone(null)
            .withCheckedInStatus(true).build();
    public static final Person JOHN_DIFF_ID = new PersonBuilder().withId("456B")
            .withName("John").withPhone("12345678")
            .withCheckedInStatus(true).build();
}
