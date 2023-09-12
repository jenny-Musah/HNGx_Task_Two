package com.hng_level_two_task.controller;

import com.hng_level_two_task.data.dto.AddPersonRequest;
import com.hng_level_two_task.data.dto.ApiResponse;
import com.hng_level_two_task.service.PersonService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<ApiResponse> addPerson(@Valid  @RequestBody AddPersonRequest addPersonRequest, @RequestParam(required = false)
    @Pattern(regexp = "^[A-Za-z]+$", message = "Enter a valid name with only letters")
    String name){
        if(name != null){
            AddPersonRequest addPersonRequest1 = new AddPersonRequest();
            addPersonRequest1.setName(name);
            return ResponseEntity.ok(personService.addPerson(addPersonRequest1));
        }
        return ResponseEntity.ok(personService.addPerson(addPersonRequest));
    }
    @GetMapping("/{user_id}")
    public ResponseEntity<ApiResponse> getPerson( @PathVariable Long user_id, @RequestParam(required = false)
    @Pattern(regexp = "^[A-Za-z]+$", message = "Enter a valid name with only letters")
    String name){
        if(name != null)return ResponseEntity.ok(personService.getPerson(personService.findPersonByName(name).getId()));
        return ResponseEntity.ok(personService.getPerson(user_id));
    }

    @PatchMapping("/{user_id}")
    public ResponseEntity<ApiResponse> updatePerson(@PathVariable Long user_id,@RequestBody AddPersonRequest addPersonRequest,
            @RequestParam(required = false)
            @Pattern(regexp = "^[A-Za-z]+$", message = "Enter a valid name with only letters")
            String name){
        if(name != null)return ResponseEntity.ok(personService.updatePerson(addPersonRequest,personService.findPersonByName(name).getId()));
        return ResponseEntity.ok(personService.updatePerson(addPersonRequest, user_id));
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<ApiResponse> deletePerson(@PathVariable Long user_id, @RequestParam(required = false)
    @Pattern(regexp = "^[A-Za-z]+$", message = "Enter a valid name with only letters")
    String name){
        if(name != null)return ResponseEntity.ok(personService.deletePerson(personService.findPersonByName(name).getId()));
        return ResponseEntity.ok(personService.deletePerson(user_id));
    }

}
