package seedu.duke.storage;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.person.Person;
import seedu.duke.person.PersonLog;

import java.util.ArrayList;

import static seedu.duke.testutil.SamplePersons.ALICE;
import static seedu.duke.testutil.SamplePersons.JACK_NO_PHONE;
import static seedu.duke.testutil.SamplePersons.JOHN;

class LogFileTest {
    LogFile logfile = new LogFile();

    @Test
    void savePerson() {

    }

    @Test
    void saveAllPersons() {
    }

    @Test
    void loadAllPersons() {
    }

    @Test
    void savePersonGson() {
    }

    @Test
    void saveAllPersonGson() throws StorageOperationException {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(JOHN);
        persons.add(ALICE);
        persons.add(JACK_NO_PHONE);
        logfile.saveAllPersons(persons);
    }

    @Test
    void loadAllPersonGson() throws StorageOperationException {
        logfile.loadAllPersons();
        System.out.println(PersonLog.getInstance().isFound(JOHN.getId()));
        System.out.println(PersonLog.getInstance().isFound(ALICE.getId()));
        System.out.println(PersonLog.getInstance().isFound(JACK_NO_PHONE.getId()));
    }
}
