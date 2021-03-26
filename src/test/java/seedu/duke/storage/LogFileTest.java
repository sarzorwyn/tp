package seedu.duke.storage;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.StorageOperationException;

import static seedu.duke.testutil.SamplePersons.JOHN;

class LogFileTest {
    LogFile logfile = new LogFile();

    @Test
    void savePerson() {
        try {
            logfile.savePerson(JOHN, true);
        } catch (StorageOperationException e) {
            e.printStackTrace();
        }
    }

    @Test
    void saveAllPersons() {
    }

    @Test
    void loadAllPersons() {
        try {
            logfile.loadAllPersons();
        } catch (StorageOperationException e) {
            e.printStackTrace();
        }
    }
}
