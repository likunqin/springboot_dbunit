package cn.brickie;

import cn.brickie.Service.PersonService;
import cn.brickie.domain.entity.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonServiceTest {
    private PersonService personService;

    @Before
    public void setUp() {
        personService = mock(PersonService.class);
    }

    @Test
    public void all() {
        when(personService.all()).thenReturn(new ArrayList<Person>() {{
            add(Person.builder().id(1).name("小明").age(25).gender(1).build());
        }});
        assertEquals("小明", personService.all().get(0).getName());
    }
}
