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
public class RoomEntity {
    @Id
    @GeneratedValue
    private int id;

    @Min(0)
    private int number;

    @Min(0)
    private int floor;

    @NotNull
    private String hotelName;

    RoomEntity(){}

    public RoomEntity(int number, int floor, String hotelName){
        this.number = number;
        this.floor = floor;
        this.hotelName = hotelName;
    }
}
