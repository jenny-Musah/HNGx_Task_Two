package com.hng_level_two_task.controller;

import com.hng_level_two_task.data.dto.AddPersonRequest;
import com.hng_level_two_task.data.dto.ApiResponse;
import com.hng_level_two_task.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<ApiResponse> addPerson(@RequestBody AddPersonRequest addPersonRequest){
        return ResponseEntity.ok(personService.addPerson(addPersonRequest));
    }
    @GetMapping("/{user_id}")
    public ResponseEntity<ApiResponse> getPerson( @PathVariable Long user_id){
        return ResponseEntity.ok(personService.getPerson(user_id));
    }

    @PatchMapping("/{user_id}")
    public ResponseEntity<ApiResponse> updatePerson(@PathVariable Long user_id,@RequestBody AddPersonRequest addPersonRequest){
        return ResponseEntity.ok(personService.updatePerson(addPersonRequest, user_id));
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<ApiResponse> deletePerson(@PathVariable Long user_id){
        return ResponseEntity.ok(personService.deletePerson(user_id));
    }

}
