package ro.fasttrackit.hotel.server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class RoomDTO {

    private int id;

    @Min(0)
    private int number;

    @Min(0)
    private int floor;

    @NotNull
    private String hotelName;

}
