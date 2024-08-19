package solvaTech.microservice.mappers;

import org.mapstruct.Mapper;
import solvaTech.microservice.dtos.LimitDto;
import solvaTech.microservice.entities.LimitEntity;

@Mapper(componentModel = "spring")
public interface LimitMapper {
    LimitDto toDto(LimitEntity entity);
    LimitEntity toEntity(LimitDto dto);
}
