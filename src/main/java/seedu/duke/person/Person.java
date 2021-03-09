package seedu.duke.person;

/**
 * Represents a Person.
 * Assumption: values are validated and not null.
 */
public class Person {
    private Id id;
    private Name name;
    private Phone phone;
    private Boolean isCheckedIn;

    public Person(Id id, Name name, Phone phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other instanceof Person) {
            return this.id.equals(other);
        }
        return false;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Boolean getCheckedIn() {
        return isCheckedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        isCheckedIn = checkedIn;
    }
}
