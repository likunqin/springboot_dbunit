package cn.brickie.Service.Impl;

import cn.brickie.Service.PersonService;
import cn.brickie.domain.entity.Person;
import cn.brickie.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> all() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }
}
