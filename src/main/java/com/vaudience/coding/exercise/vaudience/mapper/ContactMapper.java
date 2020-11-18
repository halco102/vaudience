package com.vaudience.coding.exercise.vaudience.mapper;

import com.vaudience.coding.exercise.vaudience.domain.Contact;
import com.vaudience.coding.exercise.vaudience.dto.ContactDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMapper { // Mapstruct NullPointerExc bug?
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);
    Contact toEntity (ContactDto contactDto);
    ContactDto toDto (Contact contact);
}
