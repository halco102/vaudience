package com.vaudience.coding.exercise.vaudience.service.implementation;

import com.vaudience.coding.exercise.vaudience.domain.Contact;
import com.vaudience.coding.exercise.vaudience.dto.ContactDto;
import com.vaudience.coding.exercise.vaudience.exception.NotFoundException;
import com.vaudience.coding.exercise.vaudience.mapper.ContactMapper;
import com.vaudience.coding.exercise.vaudience.repositories.ContactRepository;
import com.vaudience.coding.exercise.vaudience.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;
    private static Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);

    public ContactServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper){
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
       }

    @Override
    public List<ContactDto> getAllContacts() {
        return contactRepository.findAll().stream().map(contactMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> filterByZipCode(String zip) {
        List<Contact> tempContact = this.contactRepository.fillterByZipCode(zip);
        if(tempContact.isEmpty()){
           throw new NotFoundException("Contact was not found ");
        }
        return this.contactRepository.fillterByZipCode(zip).stream().map(contactMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<ContactDto> saveContact(ContactDto contactDto) {
            Contact tempContact = contactRepository.save(ContactMapper.INSTANCE.toEntity(contactDto));
            ContactDto contact = ContactMapper.INSTANCE.toDto(tempContact);
            logger.info("Contact created");

            return new ResponseEntity<ContactDto>(contact, HttpStatus.CREATED);
    }
}
