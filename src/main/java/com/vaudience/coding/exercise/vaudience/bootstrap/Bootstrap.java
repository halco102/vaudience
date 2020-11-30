package com.vaudience.coding.exercise.vaudience.bootstrap;

import com.vaudience.coding.exercise.vaudience.domain.Address;
import com.vaudience.coding.exercise.vaudience.domain.Contact;
import com.vaudience.coding.exercise.vaudience.domain.Role;
import com.vaudience.coding.exercise.vaudience.domain.User;
import com.vaudience.coding.exercise.vaudience.repositories.AddressRepository;
import com.vaudience.coding.exercise.vaudience.repositories.ContactRepository;
import com.vaudience.coding.exercise.vaudience.repositories.RoleRepository;
import com.vaudience.coding.exercise.vaudience.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class Bootstrap implements CommandLineRunner {

    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public Bootstrap(AddressRepository addressRepository, ContactRepository contactRepository, UserRepository userRepository, RoleRepository roleRepository){
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
            System.out.println("Started bootstrap");
            Address address = new Address("Lukavac","75300");
            Address address1 = new Address("Tuzla", "00000");

        Role role = new Role("USER");
        roleRepository.save(role);

            User user = new User("halco","123");
            User user1 = new User("weejws","222");
            user.setRoles(Arrays.asList(role));
            userRepository.save(user);
            userRepository.save(user1);

            addressRepository.save(address);
            addressRepository.save(address1);

            Contact contact = new Contact();
            contact.setFirstName("Admir");
            contact.setLastName("Halilovic");
            LocalDate localDate = LocalDate.of(1997,4,11);
            contact.setDateOfBirth(localDate);
            contact.setAddress(address);
            contactRepository.save(contact);


            Contact contact1 = new Contact("Lejla","Bandic");
            LocalDate dobContact1 = LocalDate.of(1998,10,07);
            contact1.setDateOfBirth(dobContact1);
            contact1.setAddress(address1);
            contactRepository.save(contact1);

            Contact contact2 = new Contact("Nedim","Vehabovic");
            LocalDate dobContact2 = LocalDate.of(1998,3,03);
            contact2.setDateOfBirth(dobContact2);
            contact2.setAddress(address1);
            contactRepository.save(contact2);

            Contact contact3 = new Contact("Amar","Ostrakovic");
            LocalDate dobContact3 = LocalDate.of(1996,9,21);
            contact3.setDateOfBirth(dobContact3);
            contact3.setAddress(address1);
            contactRepository.save(contact3);

            Contact contact4 = new Contact("Dino","Gradaskic");
            LocalDate dobContact4 = LocalDate.of(1998,7,19);
            contact4.setDateOfBirth(dobContact4);
            contact4.setAddress(address);
            contactRepository.save(contact4);

            System.out.println("End bootstrap");
    }
}
