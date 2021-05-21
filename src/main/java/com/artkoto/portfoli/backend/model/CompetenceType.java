package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data @Entity @Table(name = "competence_types")
public class CompetenceType {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "show")
    private String afficher;

    @OneToMany
    private Set<Competence> competences;

}
