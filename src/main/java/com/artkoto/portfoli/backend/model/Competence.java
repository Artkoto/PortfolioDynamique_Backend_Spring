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
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "competence_type_id")
    private CompetenceType competenceType;
}
