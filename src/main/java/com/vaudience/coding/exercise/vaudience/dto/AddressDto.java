package com.vaudience.coding.exercise.vaudience.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressDto {

    private Long id;
    @NotBlank
    @Size(min = 2,max = 40,message = "City name has is from 2 to 40 characters long")
    private String city;
    @NotBlank
    private String postalCode;

    public AddressDto(){}

    public AddressDto(String city, String postalCode){
        this.city = city;
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }



}
