package solvaTech.microservice.mappers;

import org.mapstruct.Mapper;
import solvaTech.microservice.dtos.RateDto;
import solvaTech.microservice.entities.RateEntity;

@Mapper(componentModel = "spring")
public interface RateMapper {
    RateDto toDto(RateEntity entity);
    RateEntity toEntity(RateDto dto);
}
