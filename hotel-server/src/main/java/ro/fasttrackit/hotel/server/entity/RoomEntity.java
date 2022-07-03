package ro.fasttrackit.hotel.server.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class RoomEntity {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String number;

    @Min(0)
    private int floor;

    @NotNull
    private String hotelName;

    @ManyToMany
    private List<CleanupEntity> cleanupList;
}
