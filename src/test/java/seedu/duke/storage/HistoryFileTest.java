package seedu.duke.storage;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.HistoryStorageException;
import seedu.duke.datetime.DateTime;
import seedu.duke.exceptions.InvalidArgumentSizeException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HistoryFileTest {
    private static final String TEST_DATA_PATH = "src/test/data/HistoryFileTest/";
    private static final String VALID_DATA_FILE = "TestHistory";
    private static final String NEW_FILE = "NewFile";

    @Test
    public void invalidFilePath_HistoryStorageExceptionThrown() {
        String invalidPath = ":-?;\0";
        assertThrows(InvalidPathException.class, () -> new HistoryFile(invalidPath));
    }
}
