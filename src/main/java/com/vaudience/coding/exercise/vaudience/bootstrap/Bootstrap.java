package com.vaudience.coding.exercise.vaudience.bootstrap;

import com.vaudience.coding.exercise.vaudience.domain.Address;
import com.vaudience.coding.exercise.vaudience.domain.Contact;
import com.vaudience.coding.exercise.vaudience.repositories.AddressRepository;
import com.vaudience.coding.exercise.vaudience.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class Bootstrap implements CommandLineRunner {

    private AddressRepository addressRepository;
    private ContactRepository contactRepository;

    public Bootstrap(AddressRepository addressRepository, ContactRepository contactRepository){
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {
            System.out.println("Started bootstrap");
            Address address = new Address("Lukavac","75300");
            Address address1 = new Address("Tuzla", "00000");

            addressRepository.save(address);
            addressRepository.save(address1);

            Contact contact = new Contact();
            contact.setFirstName("Admir");
            contact.setLastName("Halilovic");

            Calendar calendar = new GregorianCalendar();
            calendar.set(1997,3,11);
            contact.setDateOfBirth(calendar.getTime());
            contact.setAddress(address);
            contactRepository.save(contact);

            Contact contact1 = new Contact("Lejla","Bandic");
            contact1.setAddress(address1);
            calendar.set(1998,9,7);
            contact1.setDateOfBirth(calendar.getTime());
            contactRepository.save(contact1);

            Contact contact2 = new Contact("Nedim","Vehabovic");
            contact2.setAddress(address1);
            contactRepository.save(contact2);

            Contact contact3 = new Contact("Amar","Ostrakovic");
            contact3.setAddress(address1);
            contactRepository.save(contact3);

            Contact contact4 = new Contact("Dino","Gradaskic");
            contact4.setAddress(address);
            contactRepository.save(contact4);

            System.out.println("End bootstrap");
    }
}
