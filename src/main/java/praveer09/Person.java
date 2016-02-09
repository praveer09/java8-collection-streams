package praveer09;

import java.time.LocalDate;

public class Person {

    private final String name;
    private final Gender gender;
    private final LocalDate birthday;

    public Person(String name, Gender gender, LocalDate birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }
    public enum Gender {
        MALE, FEMALE
    }

    public String name() {
        return name;
    }

    public Gender gender() {
        return gender;
    }

    public LocalDate birthday() {
        return birthday;
    }

    public int age() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

}
