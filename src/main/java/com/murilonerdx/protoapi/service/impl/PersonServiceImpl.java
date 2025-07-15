package com.murilonerdx.protoapi.service.impl;

import com.github.javafaker.Faker;
import com.murilonerdx.protoapi.model.Person;
import com.murilonerdx.protoapi.repository.PersonRepository;
import com.murilonerdx.protoapi.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
	private final PersonRepository repository;

	public PersonServiceImpl(PersonRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Person> getAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Person> getById(String id) {
		return repository.findById(id);
	}

	@Override
	public Person create(Person person) {
		person.setId(null);
		return repository.save(person);
	}

	@Override
	public Person update(Person person) {
		return repository.save(person);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
	}

	@Override
	public List<Person> generatePeople(Integer quantity) {
		List<Person> peoples = new ArrayList<>();
		final Faker faker = new Faker();

		if (quantity <= 0) {
			return List.of();
		}
		for (int i = 0; i < quantity; i++) {
			peoples.add(
					Person.builder()
							.fullName(faker.name().fullName())
							.age(faker.number().numberBetween(0, 100))
							.birthDate(faker.date().birthday())
							.build()
			);
		}

		return repository.saveAll(peoples);
	}

	@Override
	public List<Person> getPersonByName(String name) {
		return repository.findByFullName(name);
	}
}
