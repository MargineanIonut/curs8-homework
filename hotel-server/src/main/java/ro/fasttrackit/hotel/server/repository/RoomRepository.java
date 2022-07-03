package ro.fasttrackit.hotel.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.hotel.server.entity.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity,Integer> {
}
