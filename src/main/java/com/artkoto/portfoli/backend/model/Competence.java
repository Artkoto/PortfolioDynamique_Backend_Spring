package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data @Entity @Table(name = "competences")
public class Competence {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(length = 25)
    private String name;
    private Integer evolution;

    private String categorie;

    @Column(length = 50)
    private String sousCategorie;
}
