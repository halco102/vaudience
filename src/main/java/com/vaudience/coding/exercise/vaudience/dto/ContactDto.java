package com.vaudience.coding.exercise.vaudience.dto;

import com.vaudience.coding.exercise.vaudience.domain.Address;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

public class ContactDto {


    private Long id;
    @NotBlank(message = "First name cant be blank")
    @Size(min = 2,max = 20,message = "First name has to be between 2 and 20")
    private String firstName;
    @NotBlank(message = "Last name cant be blank")
    @Size(min = 2,max = 20,message = "Last name has to be between 2 and 20")
    private String lastName;
    @NotNull
    private LocalDate dateOfBirth;
    private Address address;

    public ContactDto(){}

    public ContactDto(String firstName, String lastName, LocalDate dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public ContactDto(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
