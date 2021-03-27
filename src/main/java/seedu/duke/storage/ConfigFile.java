package seedu.duke.storage;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.Properties;

public class ConfigFile {

    public static final String CONFIG_FILE = "config.properties";
    public static final String DIRECTORY_HOME = System.getProperty("user.dir");

    private final Properties prop;
    private String StorageFilePath;

    /** Runs load when initialized. */
    public ConfigFile() throws InvalidPathException {
        prop = new Properties();
        this.load();
    }

    public void load() {
        try {
            FileInputStream inputStream = new FileInputStream(CONFIG_FILE);
            prop.load(inputStream);
            StorageFilePath = prop.getProperty("StorageFilePath");
        } catch (IOException e) {
            // If the file does not exist, return a null Storage file path
            StorageFilePath = null;
        }
    }

    public String getStorageFilePath() {
        return StorageFilePath;
    }

    public void setStorageFilePath(String storageFilePath) {
        StorageFilePath = storageFilePath;
        prop.setProperty("StorageFilePath", storageFilePath);
    }
}
