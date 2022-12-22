package com.post.az.mapper;

import com.post.az.dto.PersonDTO;
import com.post.az.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel =  "spring")
public interface PersonMapper {

    Person dtoToEntity(PersonDTO dto);

    PersonDTO entityToDto(Person person);



}
