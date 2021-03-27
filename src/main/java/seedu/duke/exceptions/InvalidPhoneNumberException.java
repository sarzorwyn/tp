package seedu.duke.exceptions;

public class InvalidPhoneNumberException extends Exception{
    public InvalidPhoneNumberException(String errorMessage) {
        super(errorMessage);
    }
}
