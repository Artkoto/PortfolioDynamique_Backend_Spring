package com.artkoto.portfoli.backend.model;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Qualification {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String date;

    private String name;

    @Column(name = "show")
    private Boolean montrer;


    private String detail;


}
