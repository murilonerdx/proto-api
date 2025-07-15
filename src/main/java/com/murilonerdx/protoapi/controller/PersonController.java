package com.murilonerdx.protoapi.controller;

import com.murilonerdx.protoapi.model.Person;
import com.murilonerdx.protoapi.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping("/persons-generate/{quantity}")
	public List<Person> generatePerson(@PathVariable("quantity") Integer quantity) {
		return personService.generatePeople(quantity);
	}

	@GetMapping()
	public List<Person> getPeople() {
		return personService.getAll();
	}

	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") String id) throws Exception {
		return personService.getById(id)
				.orElseThrow(() -> new Exception("Not found id"));
	}

	@PostMapping("/")
	public Person createPerson(@RequestBody Person person) {
		return personService.create(person);
	}

	@PutMapping
	public Person updatePerson(@RequestBody Person person) {
		return personService.update(person);
	}

	@DeleteMapping
	public void deletePerson(@RequestBody Person person) {
		personService.delete(person.getId());
	}

}
