package seedu.duke.storage;

import com.google.gson.Gson;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.model.person.Person;
import seedu.duke.model.PersonLog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogFile {
    private static final String DEFAULT_STORAGE_FILEPATH = "LogFile";

    private String path;

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

    /**
     * Saves the current list of visitors in the trackingList into Logfile.
     *
     * @param persons tracking list containing the current list of visitors
     * @throws StorageOperationException Exception thrown if there is error with storage
     *     operation such as accessing file or creating file
     */
    public void saveAllPersons(ArrayList<Person> persons) throws StorageOperationException {
        Gson gson = new Gson();
        final List<String> gsonPersons = new ArrayList<>();
        persons.forEach(person -> gsonPersons.add(gson.toJson(person)));

        StorageFile storage = new StorageFile(path);
        storage.saveLogFile(gsonPersons);
    }

    /**
     * Loads the list of visitors stored in the log file into temp tracking list.
     * via get instance
     *
     * @throws StorageOperationException Exception throw if there is any error with
     *     storage operation such as accessing file or creating file
     */
    public void loadAllPersons() throws StorageOperationException {
        StorageFile storage = new StorageFile(path);
        List<String> jsonLogs = storage.loadLogFile();

        if (jsonLogs == null) {
            return;
        }

        Person person;
        Gson gson = new Gson();
        for (String eachLog : jsonLogs) {
            person = gson.fromJson(eachLog, Person.class);
            PersonLog.getInstance().addPerson(person);
        }
    }

    public void setPath(String path) {
        this.path = path;
    }
}
