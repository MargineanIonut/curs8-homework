package ro.fasttrackit.hotel.server.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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

    RoomEntity(){}
}
