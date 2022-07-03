package ro.fasttrackit.hotel.server.entity;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
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

    public ReviewEntity(String message,Integer rating,String touristName, RoomEntity room) {
        this.message = message;
        this.rating = rating;
        this.touristName = touristName;
        this.room = room;
    }
}
