package ro.fasttrackit.hotel.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.hotel.server.entity.CleanupEntity;

public interface CleanupRepository extends JpaRepository<CleanupEntity,Integer> {
}
