package io.github.offjaao.spring.repository;

import io.github.offjaao.spring.domain.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> listAll();

}
