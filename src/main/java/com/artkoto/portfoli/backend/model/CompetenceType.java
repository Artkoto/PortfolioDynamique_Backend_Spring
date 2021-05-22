package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data @Entity @Table(name = "competence_types")
public class CompetenceType {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(length = 25)
    private String name;

}
