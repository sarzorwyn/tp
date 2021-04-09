package seedu.duke.storage;

import org.junit.jupiter.api.Test;

import java.nio.file.InvalidPathException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HistoryFileTest {

    @Test
    public void invalidFilePath_HistoryStorageExceptionThrown() {
        String invalidPath = ":-?;\0";
        assertThrows(InvalidPathException.class, () -> new HistoryFile(invalidPath));
    }
}
