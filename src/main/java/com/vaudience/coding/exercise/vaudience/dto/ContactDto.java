package com.vaudience.coding.exercise.vaudience.dto;

import com.vaudience.coding.exercise.vaudience.domain.Address;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class ContactDto {

    @NotNull
    private Long id;
    @NotNull
    @Size(min = 2,max = 20,message = "First name has to be between 2 and 20")
    private String firstName;
    @NotNull
    @Size(min = 2,max = 20,message = "Last name has to be between 2 and 20")
    private String lastName;
    @NotNull
    @Min(value = 1960, message = "Date cant be less than 1960")
    @Max(value = 2020, message = "Date cant be greater than 2020")
    private Date dateOfBirth = new Date();
    
    private Address address;

    public ContactDto(){}

    public ContactDto(String firstName, String lastName, String date){
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
