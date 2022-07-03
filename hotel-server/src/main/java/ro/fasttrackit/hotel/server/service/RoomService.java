package ro.fasttrackit.hotel.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.hotel.server.model.RoomDTO;
import ro.fasttrackit.hotel.server.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository repository;


    public List<RoomDTO> getAll() {
        return repository.findAll().stream()
                .map(room -> getRoomDTO(room))
                .toList();
    }

    private RoomDTO getRoomDTO(ro.fasttrackit.hotel.server.entity.RoomEntity room) {
        return new RoomDTO(room.getId(), room.getNumber(), room.getFloor(), room.getHotelName());
    }

    public Optional<RoomDTO> get(Integer roomId) {
        return repository.findById(roomId).map(room -> getRoomDTO(room));
    }
}
