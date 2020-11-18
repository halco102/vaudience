package com.vaudience.coding.exercise.vaudience.repositories;

import com.vaudience.coding.exercise.vaudience.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Long> {

    @Query(value = "Select * from contact as c inner join address as a on c.address_id = a.id where a.postal_code = ?1",nativeQuery = true)
    public List<Contact> fillterByZipCode(String zip);

}
