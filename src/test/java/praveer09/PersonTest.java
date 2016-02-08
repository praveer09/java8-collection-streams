package praveer09;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static praveer09.Person.Sex.FEMALE;
import static praveer09.Person.Sex.MALE;

public class PersonTest {

    private List<Person> team;

    @Before
    public void setUp() throws Exception {
        team = Arrays.asList(
            new Person("Archer",    MALE,       LocalDate.of(1986, 1, 9)),
            new Person("Bach",      MALE,       LocalDate.of(1987, 2, 3)),
            new Person("Caesar",    MALE,       LocalDate.of(1988, 3, 3)),
            new Person("Daniel",    MALE,       LocalDate.of(1989, 4, 3)),
            new Person("Earl",      MALE,       LocalDate.of(1990, 5, 3)),
            new Person("Adele",     FEMALE,     LocalDate.of(1986, 1, 3)),
            new Person("Barbara",   FEMALE,     LocalDate.of(1987, 2, 3)),
            new Person("Carin",     FEMALE,     LocalDate.of(1988, 3, 3)),
            new Person("Daisy",     FEMALE,     LocalDate.of(1989, 4, 3)),
            new Person("Earlene",   FEMALE,     LocalDate.of(1990, 5, 3))
        );
    }

    @Test // SELECT * FROM Person team
    public void shouldReturnTheTeam() throws Exception {
        List<Person> result = team.stream()
            .collect(toList());

        assertThat(result).hasSize(10).containsAll(team);
    }

    @Test // SELECT name FROM Person
    public void shouldSelectNamesFromTeam() throws Exception {
        List<String> names = team.stream()
            .map(Person::name)
            .collect(toList());

        assertThat(names).hasSize(10).contains(
            "Archer",   "Bach",     "Caesar",   "Daniel",   "Earl",
            "Adele",    "Barbara",  "Carin",    "Daisy",    "Earlene"
        );
    }

    @Test // SELECT name FROM Person WHERE gender = FEMALE
    public void shouldFilterBasedOnGender() throws Exception {
        List<String> names = team.stream()
            .filter(p -> FEMALE.equals(p.gender()))
            .map(Person::name)
            .collect(toList());

        assertThat(names).hasSize(5).contains(
            "Adele",    "Barbara",  "Carin",    "Daisy",    "Earlene"
        );
    }
}
