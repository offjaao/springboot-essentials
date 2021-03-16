package io.github.offjaao.spring.controller;

import io.github.offjaao.spring.domain.Person;
import io.github.offjaao.spring.service.PersonService;
import io.github.offjaao.spring.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("persons")
@Log4j2
@RequiredArgsConstructor
public class PersonController {

    private final DateUtil dateUtil;
    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> list() {
        log.info(dateUtil.formatLocalDateTime(LocalDateTime.now()));
        return ResponseEntity.ok(personService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Person> findById(@PathVariable long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return new ResponseEntity<>(personService.save(person), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Person> delete(@PathVariable long id) {
        personService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
