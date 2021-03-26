package seedu.duke.person;

import java.util.HashMap;

public class PersonLog {
    private static PersonLog instance = null;
    private HashMap<Id, Person> personLog;

    /**
     * Using Singleton design pattern.
     */
    private PersonLog() {
        personLog = new HashMap<>();
    }

    public static PersonLog getInstance() {
        if (instance == null) {
            instance = new PersonLog();
        }
        return instance;
    }

    public void addPerson(Person person) {
        assert !isFound(person.getId()) : "Person cannot already exist in the log";
        personLog.put(person.getId(), person);
        
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
}
