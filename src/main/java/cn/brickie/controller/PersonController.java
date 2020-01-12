package cn.brickie.controller;

import cn.brickie.Service.PersonService;
import cn.brickie.domain.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> all() {
        return personService.all();
    }

    @GetMapping("{id}")
    public Person getById(@PathVariable Integer id) {
        return personService.getById(id);
    }
}
