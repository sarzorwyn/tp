package seedu.duke.storage;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static seedu.duke.testutil.SamplePersons.JOHN;

class LogFileTest {
    LogFile logfile = new LogFile();

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
        try {
            logfile.loadAllPersons();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
