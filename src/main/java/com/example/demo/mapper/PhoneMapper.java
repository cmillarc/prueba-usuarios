package com.example.demo.mapper;

import com.example.demo.dto.PhoneDTO;
import com.example.demo.model.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PhoneMapper {
    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);
    Phone phoneDTOtoPhone(PhoneDTO phoneDTO);

}
