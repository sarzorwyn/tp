package seedu.duke.person;

import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.storage.LogFile;

import java.util.ArrayList;
import java.util.HashMap;

public class PersonLog {
    private static PersonLog theOnlyPersonLog = null;
    private HashMap<Id, Person> personLog;
    private LogFile logFile;

    /**
     * Using Singleton design pattern.
     */
    private PersonLog() {
        personLog = new HashMap<>();
        logFile = new LogFile();
    }

    public static PersonLog getInstance() {
        if (theOnlyPersonLog == null) {
            theOnlyPersonLog = new PersonLog();
        }
        return theOnlyPersonLog;
    }

    public void addPerson(Person person) throws StorageOperationException {
        assert !isFound(person.getId()) : "Person cannot already exist in the log";
        personLog.put(person.getId(), person);
        logFile.savePerson(person, true);
    }

    public boolean isFound(Id id) {
        return personLog.containsKey(id);
    }

    public Person findPerson(Id id) {
        return isFound(id) ? personLog.get(id) : null;
    }

    public void modifyPerson(Person person) {
        personLog.replace(person.getId(), person);
    }

    // Actually not needed I just put here first.
    public void saveAllPersons() throws StorageOperationException {
        ArrayList<Person> persons = new ArrayList<>(personLog.values());
        logFile.saveAllPersons(persons);
    }

    public void loadAllPersons() throws StorageOperationException {
        logFile.loadAllPersons();
    }

    public void clearAllPersons() throws StorageOperationException {
        personLog.clear();
        logFile.clear();
    }
}
