package solvaTech.microservice.services;

import solvaTech.microservice.dtos.TransactionDto;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    TransactionDto doTransaction(String accountName, String accountTo, BigDecimal amount, String currency, String categoryName);
    List<TransactionDto> getTransactionsExceededLimit();

}
