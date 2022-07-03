package ro.fasttrackit.hotel.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "facilities")
@Getter
@Setter
public class RoomFacilitiesEntity {
    @Id
    @GeneratedValue
    private int id;

    private boolean tv;
    private boolean doubleBed;

    @OneToOne
    private RoomEntity room;

    public RoomFacilitiesEntity(boolean tv, boolean doubleBed, RoomEntity room) {
        this.tv = tv;
        this.doubleBed = doubleBed;
        this.room = room;
    }
}
