package com.vaudience.coding.exercise.vaudience.controller;

import com.vaudience.coding.exercise.vaudience.dto.AddressDto;
import com.vaudience.coding.exercise.vaudience.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(AddressController.HOME_URL)
public class AddressController {
    public static final String HOME_URL ="/api/v1/address" ;
    private final AddressService addressService;

    public AddressController (AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping("")
    public ResponseEntity<List<AddressDto>> getAllAddresses(){
        List<AddressDto> tempAddress = this.addressService.getAllAddresses();
        return new ResponseEntity<List<AddressDto>>(tempAddress, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<AddressDto> saveNewAddress(@Valid @RequestBody AddressDto addressDto){
        return this.addressService.saveAddress(addressDto);
    }
}
