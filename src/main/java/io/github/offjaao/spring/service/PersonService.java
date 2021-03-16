package io.github.offjaao.spring.service;

import io.github.offjaao.spring.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PersonService {

    private static final List<Person> persons;

    static {
        persons = new ArrayList<>(List.of(new Person(1L, "Pedro"),
                new Person(2L, "João")));
    }

    public List<Person> listAll() {
        return persons;
    }

    public Person findById(long id) {
        return persons.stream().filter(person -> person.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Person id not found."));
    }


    public Person save(Person person) {
        person.setId(ThreadLocalRandom.current().nextLong(3, 100));
        persons.add(person);

        return person;
    }

    public void delete(long id) {
        persons.remove(findById(id));
    }
}
