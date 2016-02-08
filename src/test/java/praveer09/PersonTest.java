package praveer09;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static praveer09.Person.Sex.MALE;

public class PersonTest {

    private List<Person> team;

    @Before
    public void setUp() throws Exception {
        team = Arrays.asList(
            new Person("Praveer", MALE, LocalDate.of(1986, 8, 9)),
            new Person("Alexander Graham Bell", MALE, LocalDate.of(1847, 3, 3))
        );
    }

    @Test // SELECT * FROM People team
    public void shouldReturnListOfPeople() throws Exception {
        List<Person> result = team.stream().collect(toList());

        Assertions.assertThat(result)
            .hasSize(team.size())
            .containsAll(team);
    }
}
