package seedu.duke.storage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.StorageOperationException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigFileTest {
    private static ConfigFile configFile;
    private static String testPath = "src/test/data/ConfigFileTest/settings.properties";
    private static String originalPath = "src/test/data/ConfigFileTest/revert.properties";

    @BeforeAll
    public static void configFileTest() {
        configFile = new ConfigFile(testPath);
    }

    @Test
    public void loadTest() {
        String expectedPath = "src/test/data/StorageFileTest/ValidData";
        configFile.load();
        assertEquals(configFile.getStorageFilePath(), expectedPath);
    }

    @Test
    public void setStorageFilePathTest() throws StorageOperationException {
        String newPath = "src/test/data/StorageFileTest/invalidData";
        configFile.setStorageFilePath(newPath);
        assertEquals(configFile.getStorageFilePath(), newPath);
    }

    @AfterEach
    public void configFileCleanup() throws Exception {
        Path test = Paths.get(testPath);
        Path original = Paths.get(originalPath);
        Files.copy(original, test, StandardCopyOption.REPLACE_EXISTING);
    }
}
