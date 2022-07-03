package ro.fasttrackit.hotel.server.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.hotel.server.entity.*;
import ro.fasttrackit.hotel.server.repository.*;

import java.time.LocalDate;
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
        var savedRooms = roomRepository.saveAll(List.of(
                (new RoomEntity(23, 2, "Hotel1")),
                (new RoomEntity(12, 12, "Hotel2")),
                (new RoomEntity(42, 5, "Hotel1")),
                (new RoomEntity(65, 78, "Hotel1"))
        ));

        var savedReviews = reviewRepository.saveAll(List.of(
                (new ReviewEntity("Good",6,"Ionut",savedRooms.get(1))),
                (new ReviewEntity("Best Room",10,"Andrei",savedRooms.get(3))),
                (new ReviewEntity("Below expectations",3,"Paula",savedRooms.get(2))),
                (new ReviewEntity("Alright",7,"Alex",savedRooms.get(1)))
                ));

        var savedFacilities = roomFacilitiesRepository.saveAll(List.of(
                new RoomFacilitiesEntity(false,true, savedRooms.get(1)),
                new RoomFacilitiesEntity(false,false,savedRooms.get(2)),
                new RoomFacilitiesEntity(true,true,savedRooms.get(0)),
                new RoomFacilitiesEntity(false,false,savedRooms.get(3))
        ));

        var savedCleaningProcedures = cleaningProcedureRepository.saveAll(List.of(
                new CleaningProcedureEntity("basic cleaning",10),
                new CleaningProcedureEntity("deep cleaning",30)
        ));

        var savedCleanupProcess = cleanupRepository.saveAll(List.of(
                new CleanupEntity(LocalDate.now(),savedCleaningProcedures.get(0),savedRooms.get(1)),
                new CleanupEntity(LocalDate.of(2000,2,23),savedCleaningProcedures.get(0),savedRooms.get(3)),
                new CleanupEntity(LocalDate.of(2020,3,1),savedCleaningProcedures.get(1),savedRooms.get(0)),
                new CleanupEntity(LocalDate.of(2022,12,12),savedCleaningProcedures.get(1),savedRooms.get(1))
        ));
    }


}
