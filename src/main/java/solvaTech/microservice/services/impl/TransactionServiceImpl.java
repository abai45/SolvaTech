package solvaTech.microservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import solvaTech.microservice.dtos.TransactionDto;
import solvaTech.microservice.repositories.TransactionsRepository;
import solvaTech.microservice.services.TransactionService;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionsRepository transactionsRepository;
    @Override
    public TransactionDto doTransaction(String accountName, String accountTo, BigDecimal amount) {
        return null;
    }

    @Override
    public List<TransactionDto> getTransactions(String accountName) {
        return null;
    }
}
