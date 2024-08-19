package solvaTech.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solvaTech.microservice.entities.RateEntity;

@Repository
public interface RateRepository extends JpaRepository<RateEntity, Long> {
}
