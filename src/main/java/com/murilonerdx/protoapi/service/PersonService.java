package com.murilonerdx.protoapi.service;

import com.murilonerdx.protoapi.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
	List<Person> getAll();
	Optional<Person> getById(String id);
	Person create(Person person);
	Person update(Person person);
	void delete(String id);
	List<Person> generatePeople(Integer quantity);
	List<Person> getPersonByName(String name);
}
