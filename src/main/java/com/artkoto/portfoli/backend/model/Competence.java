package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data @Entity @Table(name = "competences")
public class Competence {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String evolution; //en pourcentage

    @Column(name = "show")
    private Boolean afficherCompetence;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "competence_type_id")
    private CompetenceType competenceType;
}
