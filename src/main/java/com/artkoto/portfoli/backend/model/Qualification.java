package com.artkoto.portfoli.backend.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
public class Qualification {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    //@Temporal(TemporalType.DATE)
    private String date; //TODO modifier le String en date

    @Column(length = 25)
    private String name;

    @Column(name = "show")
    private Boolean montrer;

    private String lieux;


    private String detail;

    //TODO mettre date de debut et fin

}
