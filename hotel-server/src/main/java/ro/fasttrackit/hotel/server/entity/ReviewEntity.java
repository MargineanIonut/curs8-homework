package ro.fasttrackit.hotel.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class ReviewEntity {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String message;

    @Min(1)
    @Max(10)
    private int rating;

    @NotNull
    private String touristName;

    @ManyToOne
    private RoomEntity room;

    ReviewEntity(){}

    public ReviewEntity(String message, RoomEntity room) {
        this.message = message;
        this.room = room;
    }
}
