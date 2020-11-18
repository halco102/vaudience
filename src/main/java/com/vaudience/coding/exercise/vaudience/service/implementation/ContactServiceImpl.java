package com.vaudience.coding.exercise.vaudience.service.implementation;

import com.vaudience.coding.exercise.vaudience.domain.Contact;
import com.vaudience.coding.exercise.vaudience.dto.ContactDto;
import com.vaudience.coding.exercise.vaudience.mapper.ContactMapper;
import com.vaudience.coding.exercise.vaudience.repositories.ContactRepository;
import com.vaudience.coding.exercise.vaudience.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;


    public ContactServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper){
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
       }

    @Override
    public List<ContactDto> getAllContacts() {
        return contactRepository.findAll().stream().map(contactMapper::toDto).collect(Collectors.toList());
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
