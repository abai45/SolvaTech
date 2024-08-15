package solvaTech.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solvaTech.microservice.entities.TransactionsEntity;

@Repository
public interface TransactionsRepository extends JpaRepository<Long, TransactionsEntity> {
}
