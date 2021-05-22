package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data @Entity @Table(name = "competence_types")
public class CompetenceType {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "show")
    private Boolean afficher;

//    @OneToMany (cascade = CascadeType.ALL)
//    private Set<Competence> competences;

}
