package com.vaudience.coding.exercise.vaudience.mapper;

import com.vaudience.coding.exercise.vaudience.domain.Address;
import com.vaudience.coding.exercise.vaudience.dto.AddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    Address toEntity (AddressDto addressDto);
    AddressDto toDto (Address address);
}
