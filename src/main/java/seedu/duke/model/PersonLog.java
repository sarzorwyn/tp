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

    /**
     * Creates an instance of PersonLog if it does not exist.
     * Else, returns an existing instance of PersonLog.
     *
     * @return instance of PersonLog
     */
    public static PersonLog getInstance() {
        if (theOnlyPersonLog == null) {
            theOnlyPersonLog = new PersonLog();
        }
        return theOnlyPersonLog;
    }

    /**
     * Adds a Person object into personLog HashMap.
     * Then, saves the entire personLog into logFile.
     *
     * @param person Person to be added in the personLog
     * @throws StorageOperationException Exception thrown if there is error with storage
     *      operation such as accessing file or creating file
     */
    public void addPerson(Person person) throws StorageOperationException {
        if (isFound(person.getId())) {
            return;
        }
        personLog.put(person.getId(), person);
        saveAllPersons();
    }

    /**
     * Checks if personLog contains a Person with the given Id.
     *
     * @param id Id of the person to be checked.
     * @return True if Person with the Id is found. False otherwise.
     */
    public boolean isFound(Id id) {
        return personLog.containsKey(id);
    }

    /**
     * Returns the Person corresponding to the Id if the Person exists in personLog.
     *
     * @param id Id of the person to be found.
     * @return Person if Person with the Id is found. Null otherwise.
     */
    public Person findPerson(Id id) {
        return isFound(id) ? new Person(personLog.get(id)) : null;
    }

    /**
     * Modifies an existing Person with the same Id in the personLog
     * by replacing the old Person.
     *
     * @param person Person to be modified
     * @throws StorageOperationException Exception thrown if there is error with storage
     *       operation such as accessing file or creating file
     */
    public void modifyPerson(Person person) throws StorageOperationException {
        personLog.replace(person.getId(), person);
        saveAllPersons();
    }

    /**
     * Saves all the Person in personLog into logFile.
     *
     * @throws StorageOperationException Exception thrown if there is error with storage
     *      operation such as accessing file or creating file
     */
    public void saveAllPersons() throws StorageOperationException {
        ArrayList<Person> persons = new ArrayList<>(personLog.values());
        logFile.saveAllPersons(persons);
    }

    /**
     * Loads all the Person from logFile into personLog.
     *
     * @throws StorageOperationException Exception thrown if there is error with storage
     *      operation such as accessing file or creating file
     */
    public void loadAllPersons() throws StorageOperationException {
        logFile.loadAllPersons();
    }

    /**
     * Changes the path of the logFile to the new given path.
     *
     * @param path Relative path of the new location
     */
    public void changePath(String path) {
        logFile.setPath(path);
    }

    /**
     * Deletes all Persons in logFile.
     *
     * @throws StorageOperationException Exception thrown if there is error with storage
     *      operation such as accessing file or creating file
     */
    public void clearAllPersons() throws StorageOperationException {
        ArrayList<Person> persons = new ArrayList<>(personLog.values());
        logFile.saveAllPersons(persons);
    }
}
