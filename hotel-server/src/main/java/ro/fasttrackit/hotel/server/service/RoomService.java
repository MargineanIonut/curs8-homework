package ro.fasttrackit.hotel.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.hotel.server.entity.RoomEntity;
import ro.fasttrackit.hotel.server.model.RoomDTO;
import ro.fasttrackit.hotel.server.repository.RoomRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository repository;


    public List<RoomDTO> getAll() {
        return repository.findAll().stream()
                .map(room -> getRoomDTO(room))
                .toList();
    }

    private RoomDTO getRoomDTO(RoomEntity room) {
        return new RoomDTO(room.getId(), room.getNumber(), room.getFloor(), room.getHotelName());
    }
}
