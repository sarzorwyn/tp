package seedu.duke.history;

import seedu.duke.datetime.DateTime;
import seedu.duke.exceptions.HistoryStorageException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class HistoryFile {

    public static final String DEFAULT_HISTORY_FILEPATH = "History";
    public static final String FILE_FORMAT = ".txt";
    public static final String DIRECTORY_HOME = System.getProperty("user.dir");

    public Path path;

    public HistoryFile() throws InvalidPathException {
        this(DEFAULT_HISTORY_FILEPATH);
    }

    public HistoryFile(String path) throws InvalidPathException {
        if (path == null) {
            path = DEFAULT_HISTORY_FILEPATH;
        }
        this.path = Paths.get(DIRECTORY_HOME,path + FILE_FORMAT);
    }

    public void save(String entry) throws HistoryStorageException {
        try {
            DateTime datetime = new DateTime();
            File file = new File(DEFAULT_HISTORY_FILEPATH + FILE_FORMAT);
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.newLine();
            br.write(entry + " " +datetime.getDateAndTimeInString());

            br.close();
            fr.close();
        } catch (IOException ioe) {
            throw new HistoryStorageException("Error writing to file: " + path);
        }
    }


}
