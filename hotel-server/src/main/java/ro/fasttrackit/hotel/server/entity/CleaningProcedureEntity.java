package ro.fasttrackit.hotel.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cleaningprocedure")
@Getter
@Setter
public class CleaningProcedureEntity {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;
    @Min(0)
    private int duration;


    public CleaningProcedureEntity(String name,int duration) {
        this.name = name;
        this.duration = duration;

    }
}
