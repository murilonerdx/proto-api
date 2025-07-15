package com.murilonerdx.protoapi.repository;

import com.murilonerdx.protoapi.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
	List<Person> findByFullName(String name);
}
