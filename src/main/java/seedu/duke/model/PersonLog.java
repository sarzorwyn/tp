package seedu.duke.model;

import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.model.person.Id;
import seedu.duke.model.person.Person;
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
        if (isFound(person.getId())) {
            return;
        }
        personLog.put(person.getId(), person);
        saveAllPersons();
    }

    public boolean isFound(Id id) {
        return personLog.containsKey(id);
    }

    public Person findPerson(Id id) {
        return isFound(id) ? new Person(personLog.get(id)) : null;
    }

    public void modifyPerson(Person person) throws StorageOperationException {
        personLog.replace(person.getId(), person);
        saveAllPersons();
    }

    public void saveAllPersons() throws StorageOperationException {
        ArrayList<Person> persons = new ArrayList<>(personLog.values());
        logFile.saveAllPersons(persons);
    }

    public void loadAllPersons() throws StorageOperationException {
        logFile.loadAllPersons();
    }

    public void changePath(String path) {
        logFile.setPath(path);
    }

    public void clearAllPersons() throws StorageOperationException {
        ArrayList<Person> persons = new ArrayList<>(personLog.values());
        logFile.saveAllPersons(persons);
    }
}
