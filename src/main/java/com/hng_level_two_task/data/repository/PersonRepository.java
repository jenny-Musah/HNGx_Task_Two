package com.hng_level_two_task.data.repository;

import com.hng_level_two_task.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
