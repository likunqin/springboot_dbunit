package cn.brickie.Service;

import cn.brickie.domain.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> all();

    Person getById(Integer id);
}
