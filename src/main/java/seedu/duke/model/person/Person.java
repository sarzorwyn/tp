package seedu.duke.model.person;

/**
 * Represents a Person.
 * Assumption: values are validated and not null.
 */
public class Person {
    private static final long serialVersionUID = 1L;
    private Id id;
    private Name name;
    private Phone phone;
    private Boolean isCheckedIn;

    public Person(Id id, Name name, Phone phone) {
        assert id != null : "ID cannot be null";
        assert phone != null : "Phone cannot be null";
        assert name != null : "Name cannot be null";

        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Person(Person another) {
        this.id = another.getId();
        this.name =  another.getName();
        this.phone = another.getPhone();
        this.isCheckedIn = another.getCheckedIn();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other instanceof Person) {
            return id.equals(((Person) other).id);
        }
        return false;
    }

    public Id getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Boolean getCheckedIn() {
        return isCheckedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        isCheckedIn = checkedIn;
    }
}
