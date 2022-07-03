package ro.fasttrackit.hotel.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "cleanupprocess")
@Getter
@Setter
public class CleanupEntity {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private LocalDate date;

    @NotNull
    private CleaningProcedureEntity procedures;


    @ManyToOne
    private RoomEntity room;

    CleanupEntity(){}

    public CleanupEntity(@NotNull CleaningProcedureEntity procedures, RoomEntity room) {
        this.procedures = procedures;
        this.room = room;
    }
}
