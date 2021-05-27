package com.artkoto.portfoli.backend.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "qualifications")
public class Qualification {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date_debut;

    @Temporal(TemporalType.DATE)
    private Date date_fin;


    @Column(length = 25)
    private String name;
    @Column(length = 50)
    private String lieux;

    @Column( length = 50)
    private String pays ;

    @Column(length = 50)
    private String ville ;

    @Column(length = 300)
    private String detail;

}
