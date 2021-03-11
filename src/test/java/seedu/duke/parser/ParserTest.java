package seedu.duke.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.commands.CheckInCommand;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ParserTest {


    @Test
    public void checkInParser_parsedCorrectly() {

        String[] result = {"john","1234A 12345678"};
        assertArrayEquals(Parser.splitTextIntoTwoFields("John 1234A 12345678"), result);

    }
}
