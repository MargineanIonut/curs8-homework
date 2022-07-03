package ro.fasttrackit.hotel.server.controller;

import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import ro.fasttrackit.hotel.server.entity.RoomEntity;
import ro.fasttrackit.hotel.server.model.RoomDTO;
import ro.fasttrackit.hotel.server.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor

public class RoomController {
    private final RoomService service;

    @GetMapping()
    List<RoomDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("roomId")
    RoomDTO getOne(@PathVariable Integer roomId){
        return service.get(roomId)
                .orElseThrow(()-> new RuntimeException("Could not find room with id " + roomId));
    }

    @PatchMapping("{roomId}")
    RoomEntity updateRoom (@PathVariable int roomId, @RequestBody RoomEntity updatedRoom){
        return service.updateRoom(roomId, updatedRoom);
    }
}
