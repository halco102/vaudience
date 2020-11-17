package com.vaudience.coding.exercise.vaudience.service;

import com.vaudience.coding.exercise.vaudience.domain.Contact;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    List<Contact> fillterByZipCode(String zip);
    void saveContact(Contact contact);
}
