package solvaTech.microservice.services.impl;

import org.springframework.stereotype.Service;
import solvaTech.microservice.dtos.TransactionDto;
import solvaTech.microservice.services.TransactionService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public TransactionDto doTransaction(String accountName, String accountTo, BigDecimal amount) {
        return null;
    }

    @Override
    public List<TransactionDto> getTransactions(String accountName) {
        return null;
    }
}
