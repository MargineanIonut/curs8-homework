package ro.fasttrackit.hotel.server.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.hotel.server.entity.RoomEntity;
import ro.fasttrackit.hotel.server.repository.*;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final RoomRepository roomRepository;
    private final RoomFacilitiesRepository roomFacilitiesRepository;
    private final ReviewRepository reviewRepository;
    private final CleanupRepository cleanupRepository;
    private final CleaningProcedureRepository cleaningProcedureRepository;

    @Override
    public void run(String... args) throws Exception {
       var savedRooms =  roomRepository.saveAll(List.of(
                (new RoomEntity(23, 2, "Hotel1")),
                (new RoomEntity(12, 12, "Hotel2")),
                (new RoomEntity(42, 5, "Hotel1")),
                (new RoomEntity(65, 78, "Hotel1"))
        ));
    }


}
