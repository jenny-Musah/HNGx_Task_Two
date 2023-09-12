package com.hng_level_two_task.service;

import com.hng_level_two_task.data.dto.AddPersonRequest;
import com.hng_level_two_task.data.dto.ApiResponse;
import com.hng_level_two_task.data.model.Person;
import com.hng_level_two_task.data.repository.PersonRepository;
import com.hng_level_two_task.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public ApiResponse addPerson(AddPersonRequest addPersonRequest) {
        isPersonValid(addPersonRequest.getName());
        Person person = new Person();
        person.setName(addPersonRequest.getName());
        personRepository.save(person);
        return new ApiResponse(ConstantUtils.ADDED_SUCCESSFULLY, true);
    }

    public ApiResponse getPerson(Long userId) {
        Person foundPerson = findPerson(userId);
        return new ApiResponse(foundPerson, true);
    }

    public ApiResponse updatePerson(AddPersonRequest addPersonRequest, Long userId) {
        Person foundPerson = findPerson(userId);
        foundPerson.setName(addPersonRequest.getName());
        personRepository.save(foundPerson);
        return new ApiResponse(ConstantUtils.UPDATED_SUCCESSFULLY, true);
    }

    private Person findPerson(Long userId){
        return personRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException(ConstantUtils.INVALID_DETAILS));
    }

    public ApiResponse deletePerson(Long  user_id) {
        Person person = findPerson(user_id);
        personRepository.delete(person);
        return new ApiResponse(ConstantUtils.DELETED_SUCCESSFULLY, true);
    }

    public Person findPersonByName(String name) {
        for (Person person : personRepository.findAll()){
            if(person.getName().equals(name))return person;
        }
        throw  new IllegalArgumentException(ConstantUtils.DOES_NOT_EXIST);
    }

    private void isPersonValid(String name){
        if(!personRepository.findAll().isEmpty()){
            for (Person person : personRepository.findAll()){
                if(person.getName().equals(name)) throw new IllegalArgumentException(ConstantUtils.ALREADY_EXIST);
            }
        }
    }
}
