package com.zarmas.ninjabackend.controller;

import com.zarmas.ninjabackend.model.ContactModel;
import com.zarmas.ninjabackend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    @Autowired
    @Qualifier("ContactServiceImplementation")
    private ContactService contactService;

    @GetMapping("/checkRest")
    public ResponseEntity<List<ContactModel>> checkRest() {
        return new ResponseEntity<>(contactService.listAllContacts(), HttpStatus.OK);
    }
}
