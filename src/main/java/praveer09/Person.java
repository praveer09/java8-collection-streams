package praveer09;

import java.time.LocalDate;

public class Person {

    private final String name;
    private final Sex gender;
    private final LocalDate birthday;

    public Person(String name, Sex gender, LocalDate birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }
    public enum Sex {
        MALE, FEMALE
    }

    public String getName() {
        return name;
    }

    public Sex getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }
}
