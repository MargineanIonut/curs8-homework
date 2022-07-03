package ro.fasttrackit.hotel.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

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
    @OneToOne
    private CleaningProcedureEntity procedures;

    @ManyToOne
    private RoomEntity room;

    CleanupEntity(){}

    public CleanupEntity(LocalDate date ,@NotNull CleaningProcedureEntity procedures, RoomEntity room) {
        this.date = date;
        this.procedures = procedures;
        this.room = room;
    }
}
