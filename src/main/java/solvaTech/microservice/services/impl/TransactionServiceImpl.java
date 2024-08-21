package solvaTech.microservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import solvaTech.microservice.dtos.TransactionDto;
import solvaTech.microservice.entities.TransactionsEntity;
import solvaTech.microservice.enums.CategoryEnum;
import solvaTech.microservice.mappers.TransactionMapper;
import solvaTech.microservice.repositories.TransactionsRepository;
import solvaTech.microservice.services.LimitService;
import solvaTech.microservice.services.RateService;
import solvaTech.microservice.services.TransactionService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ZERO;
import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionsRepository transactionsRepository;
    private final TransactionMapper transactionMapper;
    private final LimitService limitService;
    private final RateService rateService;

    @Override
    public TransactionDto doTransaction(String accountName, String accountTo, BigDecimal amount, String currency, String categoryName) {
        var limitDto = limitService.getLimitsByCategoryAndDate(categoryName, null)
                .stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Limit by category not found"));

        BigDecimal rate = rateService.getRate(currency, "USD").getRate();
        BigDecimal amountInUSD = amount.multiply(rate);
        BigDecimal remainingLimit = limitDto.getLimitSum().subtract(amountInUSD);
        boolean limitExceeded = remainingLimit.compareTo(ZERO) < 0;

        var transactionEntity = new TransactionsEntity();
        transactionEntity.setAccountFrom(accountName);
        transactionEntity.setAccountTo(accountTo);
        transactionEntity.setAmount(amount);
        transactionEntity.setCurrency(currency);
        transactionEntity.setCategoryEnum(CategoryEnum.valueOf(categoryName));
        transactionEntity.setDateTime(now());
        transactionEntity.setLimitExceeded(limitExceeded);
        transactionsRepository.save(transactionEntity);

        if (limitExceeded) {
            throw new RuntimeException(String.format(
                    "Transaction exceeds limit. \nLimit: %s USD,\nAmount: %s USD,\nRemaining Limit: %s USD",
                    limitDto.getLimitSum(), amountInUSD, remainingLimit
            ));
        }

        return transactionMapper.toDto(transactionEntity);
    }


    @Override
    public List<TransactionDto> getTransactionsExceededLimit() {
        var limitExceededTransactions = transactionsRepository.findByLimitExceededTrue();

        return limitExceededTransactions.stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList());
    }
}
