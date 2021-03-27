package seedu.duke.datetime;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DateTime {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    public String getDateAndTimeInString() {
        return dtf.format(now);
    }
}
