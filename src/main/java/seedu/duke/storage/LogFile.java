package seedu.duke.storage;

import com.google.gson.Gson;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.person.Person;
import seedu.duke.person.PersonLog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogFile {
    private static final String DEFAULT_STORAGE_FILEPATH = "LogFile";

    private final String path;

    /**
     * Creates LogFile file with default path.
     */
    public LogFile() {
        this(DEFAULT_STORAGE_FILEPATH);
    }

    /**
     * Creates LogFile file with given file path.
     * @param path The path that will be used for storage
     */
    public LogFile(String path) {
        this.path = path;
    }

    public void savePerson(Person person) throws StorageOperationException {
        Gson gson = new Gson();
        gson.toJson(person);

        StorageFile storage = new StorageFile(path);
        storage.saveLogFile(Collections.singletonList(gson.toJson(person)));
    }

    public void saveAllPersons(ArrayList<Person> persons) throws StorageOperationException {
        Gson gson = new Gson();
        final List<String> gsonPersons = new ArrayList<>();
        persons.forEach(person -> gsonPersons.add(gson.toJson(person)));

        StorageFile storage = new StorageFile(path);
        storage.saveLogFile(gsonPersons);
    }

    public void loadAllPersons() throws StorageOperationException {
        StorageFile storage = new StorageFile(path);
        List<String> jsonLogs = storage.loadLogFile();

        Person person;
        Gson gson = new Gson();
        for (String eachLog : jsonLogs) {
            person = gson.fromJson(eachLog, Person.class);
            PersonLog.getInstance().addPerson(person);
        }
    }

}
