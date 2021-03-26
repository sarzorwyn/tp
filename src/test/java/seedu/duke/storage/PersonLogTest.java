package seedu.duke.storage;

import org.junit.jupiter.api.Test;
import seedu.duke.person.Person;

import java.io.IOException;
import java.util.ArrayList;

import static seedu.duke.testutil.SamplePersons.JOHN;

class PersonLogTest {
    PersonLog logfile = new PersonLog();

    @Test
    void savePerson() {
        try {
            logfile.savePerson(JOHN);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void saveAllPersons() {
    }

    @Test
    void loadAllPersons() {
        ArrayList<Person> persons = null;
        try {
            persons = logfile.loadAllPersons();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Person person : persons) {
            System.out.println(person.getName());
        }
    }
}
