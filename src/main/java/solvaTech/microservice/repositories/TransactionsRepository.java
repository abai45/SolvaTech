package solvaTech.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solvaTech.microservice.entities.TransactionsEntity;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionsEntity, Long> {
    List<TransactionsEntity> findByLimitExceededTrue();
}
