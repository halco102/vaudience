package com.vaudience.coding.exercise.vaudience.service;

import com.vaudience.coding.exercise.vaudience.domain.Contact;
import com.vaudience.coding.exercise.vaudience.dto.ContactDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactService {
    List<ContactDto> getAllContacts();
    List<Contact> fillterByZipCode(String zip);
    void saveContact(Contact contact);
}
