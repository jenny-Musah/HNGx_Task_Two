package com.hng_level_two_task.service;

import com.hng_level_two_task.data.dto.AddPersonRequest;
import com.hng_level_two_task.data.model.Person;
import com.hng_level_two_task.data.repository.PersonRepository;
import com.hng_level_two_task.utils.ConstantUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired private PersonRepository personRepository;
    @Autowired private PersonService personService;

    @BeforeEach
    public void setUp(){
        personRepository.deleteAll();
    }


    @Test
    void addPerson() {
        AddPersonRequest addPersonRequest = new AddPersonRequest();
        addPersonRequest.setName("Jennifer");
        assertEquals(ConstantUtils.ADDED_SUCCESSFULLY, personService.addPerson(addPersonRequest).getData());
        assertEquals(1, personRepository.findAll().size());
    }

    @Test
    void getPerson() {
       addPerson();
        assertEquals("Jennifer", personRepository.findAll().get(0).getName());

    }

    @Test
    void updatePerson() {
        addPerson();
        assertEquals("Jennifer", personRepository.findAll().get(0).getName());

        AddPersonRequest addPersonRequest = new AddPersonRequest();
        addPersonRequest.setName("Unika");
        assertEquals(ConstantUtils.UPDATED_SUCCESSFULLY, personService.updatePerson(addPersonRequest, personRepository.findAll().get(0).getId()).getData());
        assertEquals("Unika",  personRepository.findAll().get(0).getName());
    }

    @Test
    void deletePerson() {
        addPerson();
        assertEquals(1, personRepository.findAll().size());
        personService.deletePerson(personRepository.findAll().get(0).getId());
        assertEquals(0, personRepository.findAll().size());
    }
}
