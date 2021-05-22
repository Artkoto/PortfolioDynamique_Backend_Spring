package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data @Entity @Table(name = "projects")
public class Projet {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name",length = (50))
    private String nomProjet;
    @Column(name = "description",length = (300))
    private String descriptionProjet;
    @Column(name = "url")
    private String urlProject;
    @Column(name = "git" )
    private String gitLink;
    @Column(name = "tools",length = (150))
    private String outils;
    @Column(name = "miniature")
    private String photo;

    @Temporal(TemporalType.DATE)
    private Date date_debut;

    @Temporal(TemporalType.DATE)
    private Date date_fin;
}
