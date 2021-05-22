package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data @Entity @Table(name = "projects")
public class Projet {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name" )
    private String nomProjet;
    @Column(name = "description")
    private String descriptionProjet;
    @Column(name = "url")
    private String urlProject;
    @Column(name = "git" )
    private String gitLink;
    @Column(name = "tools")
    private String outils; //TODO à corriger
    @Column(name = "show")
    private boolean afficherProjet;
    @Column(name = "miniature")
    private String photo;

}
