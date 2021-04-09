package seedu.duke.storage;

import org.junit.jupiter.api.Test;

import java.nio.file.InvalidPathException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.duke.testutil.SamplePersons.ALICE;

public class HistoryFileTest {
    private static final String TEST_DATA_PATH = "src/test/data/HistoryFileTest/";
    private static final String VALID_DATA_FILE = "TestHistory";
    private static final String NEW_FILE = "NewHistoryFile";

    @Test
    public void invalidFilePath_HistoryStorageExceptionThrown() {
        String invalidPath = ":-?;\0";
        assertThrows(InvalidPathException.class, () -> new HistoryFile(invalidPath));
    }
}
