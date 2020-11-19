package com.vaudience.coding.exercise.vaudience.service;

import com.vaudience.coding.exercise.vaudience.domain.Address;
import com.vaudience.coding.exercise.vaudience.dto.AddressDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AddressService {
    List<AddressDto> getAllAddresses();
    ResponseEntity<AddressDto> saveAddress(AddressDto addressDto);
}
