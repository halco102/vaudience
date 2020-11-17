package com.vaudience.coding.exercise.vaudience.service;

import com.vaudience.coding.exercise.vaudience.domain.Address;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AddressService {
    ResponseEntity<List<Address>> getAllAddresses();

}
