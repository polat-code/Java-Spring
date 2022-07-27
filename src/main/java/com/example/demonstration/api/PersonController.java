package com.example.demonstration.api;

import com.example.demonstration.model.Person;
import com.example.demonstration.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Validated @NonNull @RequestBody Person person) {
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }
    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }
    @PutMapping("/{id}")
    public void updatePersonById(@PathVariable("id") UUID id ,@Validated @NonNull  @RequestBody Person person) {
        personService.updatePersonById(id,person);
    }


}
