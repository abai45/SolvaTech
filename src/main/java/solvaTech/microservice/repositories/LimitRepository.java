package solvaTech.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solvaTech.microservice.entities.LimitEntity;

@Repository
public interface LimitRepository extends JpaRepository<LimitEntity, Long> {
}
