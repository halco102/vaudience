package com.vaudience.coding.exercise.vaudience.service.implementation;

import com.vaudience.coding.exercise.vaudience.dto.AddressDto;
import com.vaudience.coding.exercise.vaudience.mapper.AddressMapper;
import com.vaudience.coding.exercise.vaudience.service.AddressService;
import com.vaudience.coding.exercise.vaudience.domain.Address;
import com.vaudience.coding.exercise.vaudience.repositories.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl  implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper){
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public List<AddressDto> getAllAddresses() {
        return this.addressRepository.findAll().stream().map(addressMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<AddressDto> saveAddress(AddressDto addressDto) {
        Address tempAddress = this.addressRepository.save(addressMapper.toEntity(addressDto));
        AddressDto address = addressMapper.toDto(tempAddress);
        return new ResponseEntity<AddressDto>(address,HttpStatus.CREATED);

    }
}
