package com.vaudience.coding.exercise.vaudience.controller;

import com.vaudience.coding.exercise.vaudience.domain.Contact;
import com.vaudience.coding.exercise.vaudience.dto.ContactDto;
import com.vaudience.coding.exercise.vaudience.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ContactController.HOME_URL)
public class ContactController {
    public static final String HOME_URL ="/api/v1/contacts" ;
    private final ContactService contactService;

    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }


    @GetMapping("")
    public ResponseEntity<List<ContactDto>> getAllContacts(){
        List<ContactDto> allContacts = this.contactService.getAllContacts();
        return new ResponseEntity<List<ContactDto>>(allContacts, HttpStatus.OK);
    }

    @GetMapping("/{zip}")
    public ResponseEntity<List<ContactDto>> filterByZipCode(@PathVariable String zip){
        List<ContactDto> getAllFilteredZipCodes = this.contactService.fillterByZipCode(zip);
        return new ResponseEntity<List<ContactDto>>(getAllFilteredZipCodes,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> createNewContact(@Valid @RequestBody ContactDto contactDto){
        this.contactService.saveContact(contactDto);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
