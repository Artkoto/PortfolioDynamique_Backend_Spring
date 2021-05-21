package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data @Entity @Table(name = "competences")
public class Competence {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String evolution; //en pourcentage

    @Column(name = "show")
    private String afficherCompetence;

    @ManyToOne
    private CompetenceType competenceTyp;
}
