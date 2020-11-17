package com.vaudience.coding.exercise.vaudience.service.implementation;

import com.vaudience.coding.exercise.vaudience.domain.Contact;
import com.vaudience.coding.exercise.vaudience.repositories.ContactRepository;
import com.vaudience.coding.exercise.vaudience.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> getAllContacts() {
        return this.contactRepository.findAll();
    }

    @Override
    public List<Contact> fillterByZipCode(String zip) {
        return this.contactRepository.fillterByZipCode(zip);
    }

    @Override
    public void saveContact(Contact contact) {
        this.contactRepository.save(contact);
    }
}
