package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name = "personnes")
public class Personne {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name" ,length = (15))
    private String nom;

    @Column(name = "last_name" ,length = (25))
    private String prenom;

    @Column(name = "post" ,length = (50))
    private String poste ;

    @Column(name = "picture_link")
    private String photo;

    @Column(name = "cv_link")
    private String cv;

    @Column(name = "about" ,length = (300))
    private String aPropos;

    @Column(name = "phone_number" ,length = (15))
    private String numero;

    @Column(name = "add_email" ,length = (50))
    private String email;

    @ManyToMany( cascade = {CascadeType.ALL})
    @JoinTable(name="personnes_hobies",
            joinColumns= @JoinColumn(name="personne_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="hobie_id", referencedColumnName="name"))
    Set<Hobie> loisirs ;

    @ManyToMany( cascade = {CascadeType.ALL})
    @JoinTable(name="personnes_formations",
            joinColumns= @JoinColumn(name="personne_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="formation_id", referencedColumnName="id"))
    Set<Formation> formations;

    @ManyToMany( cascade = {CascadeType.ALL})
    @JoinTable(name="personnes_experiences",
            joinColumns= @JoinColumn(name="personne_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="experience_id", referencedColumnName="id"))
    Set<Experience>experiences;

    @ManyToMany (cascade = {CascadeType.ALL})
    @JoinTable(name="personnes_competences",
            joinColumns= @JoinColumn(name="personne_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="competence_id", referencedColumnName="id"))
    Set<Competence>competences;

    @ManyToMany (cascade = {CascadeType.ALL})
    @JoinTable(name="personnes_projets",
            joinColumns= @JoinColumn(name="personne_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="projet_id", referencedColumnName="id"))
    Set<Projet>projets;


}
