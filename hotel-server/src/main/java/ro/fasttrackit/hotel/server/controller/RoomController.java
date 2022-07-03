package ro.fasttrackit.hotel.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
