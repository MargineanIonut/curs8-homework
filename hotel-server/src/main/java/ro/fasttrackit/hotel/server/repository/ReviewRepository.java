package ro.fasttrackit.hotel.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.hotel.server.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer> {
}
