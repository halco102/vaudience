package com.vaudience.coding.exercise.vaudience.service.implementation;

import com.vaudience.coding.exercise.vaudience.dto.AddressDto;
import com.vaudience.coding.exercise.vaudience.exception.DuplicateFoundException;
import com.vaudience.coding.exercise.vaudience.exception.NotFoundException;
import com.vaudience.coding.exercise.vaudience.mapper.AddressMapper;
import com.vaudience.coding.exercise.vaudience.service.AddressService;
import com.vaudience.coding.exercise.vaudience.domain.Address;
import com.vaudience.coding.exercise.vaudience.repositories.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AddressServiceImpl  implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private static Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);


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
        Address tempAddress;
        AddressDto address;


        if(this.addressRepository.findAll().stream().anyMatch(object -> object.getCity().equals(addressDto.getCity()))
        ){
            throw new DuplicateFoundException("Duplicate found");
         }

        try {
             tempAddress = this.addressRepository.save(addressMapper.toEntity(addressDto));
             address = addressMapper.toDto(tempAddress);

        }catch (Exception e){
            logger.warn(e.getMessage());
            throw (e);
        }

        return new ResponseEntity<AddressDto>(address,HttpStatus.CREATED);
    }
}
