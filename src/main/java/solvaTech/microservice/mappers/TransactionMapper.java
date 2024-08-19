package solvaTech.microservice.mappers;

import org.mapstruct.Mapper;
import solvaTech.microservice.dtos.TransactionDto;
import solvaTech.microservice.entities.TransactionsEntity;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionDto toDto(TransactionsEntity entity);
    TransactionsEntity toEntity(TransactionDto dto);
}
