package seedu.duke.person;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.StorageOperationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.testutil.SamplePersons.ALICE;
import static seedu.duke.testutil.SamplePersons.BOB;
import static seedu.duke.testutil.SamplePersons.JACK_NO_PHONE;
import static seedu.duke.testutil.SamplePersons.JOHN;
import static seedu.duke.testutil.SamplePersons.MARY;
import static seedu.duke.testutil.SamplePersons.NON_EXISTENT_PERSON;

class PersonLogTest {
    PersonLog personLog = PersonLog.getInstance();

    @Test
    public void personLogTest() {
        personLog.changePath("test/LogFile");
        try {
            personLog.clearAllPersons();
            personLog.addPerson(ALICE);
            personLog.addPerson(BOB);
            personLog.addPerson(JOHN);
            personLog.addPerson(MARY);
            personLog.addPerson(JACK_NO_PHONE);
            personLog.saveAllPersons();
            personLog.loadAllPersons();
        } catch (StorageOperationException e) {
            System.out.println(e.getMessage());
        }
        testIsFound();
        testFindPerson();
        testModifyPerson();
    }

    void testIsFound() {
        assertTrue(personLog.isFound(ALICE.getId()));
        assertTrue(personLog.isFound(JACK_NO_PHONE.getId()));
        assertFalse(personLog.isFound(NON_EXISTENT_PERSON.getId()));
    }

    void testFindPerson() {
        assertEquals(JOHN, personLog.findPerson(JOHN.getId()));
        assertNull(personLog.findPerson(NON_EXISTENT_PERSON.getId()));
    }

    void testModifyPerson() {
        String jackNewPhone = "12345678";
        JACK_NO_PHONE.getPhone().setPhoneNo(jackNewPhone);
        try {
            personLog.modifyPerson(JACK_NO_PHONE);
        } catch (StorageOperationException e) {
            System.out.println(e.getMessage());
        }

        Person newJack = personLog.findPerson(JACK_NO_PHONE.getId());

        assertEquals(jackNewPhone, newJack.getPhone().getPhoneNo());
    }
}