package ro.fasttrackit.hotel.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.hotel.server.entity.CleaningProcedureEntity;

import javax.persistence.criteria.CriteriaBuilder;

public interface CleaningProcedureRepository extends JpaRepository<CleaningProcedureEntity, Integer> {
}
