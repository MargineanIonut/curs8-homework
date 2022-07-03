package ro.fasttrackit.hotel.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.hotel.server.entity.RoomFacilitiesEntity;

public interface RoomFacilitiesRepository extends JpaRepository<RoomFacilitiesEntity,Integer> {
}
