package solvaTech.microservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solvaTech.microservice.dtos.TransactionDto;
import solvaTech.microservice.dtos.TransactionFilterDto;
import solvaTech.microservice.dtos.TransactionRequestDto;
import solvaTech.microservice.services.TransactionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/do")
    public ResponseEntity<TransactionDto> doTransaction(@RequestBody TransactionRequestDto transactionRequestDto) {
        try {
            TransactionDto transaction = transactionService.doTransaction(
                    transactionRequestDto.getAccountFrom(),
                    transactionRequestDto.getAccountTo(),
                    transactionRequestDto.getAmount(),
                    transactionRequestDto.getCurrency(),
                    transactionRequestDto.getCategoryName()
            );
            return ResponseEntity.ok(transaction);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/exceeded")
    public ResponseEntity<List<TransactionDto>> getTransactionsExceededLimit(@RequestBody TransactionFilterDto filterDto) {
        List<TransactionDto> exceededTransactions = transactionService.getTransactionsExceededLimit();
        return ResponseEntity.ok(exceededTransactions);
    }
}
