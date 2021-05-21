package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "personnes")
public class Personne {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String nom;

    @Column(name = "last_name")
    private String prenom;

    @Column(name = "post")
    private String poste ;

    @Column(name = "picture_link")
    private String photo;

    @Column(name = "cv_link")
    private String cv;

    @Column(name = "about")
    private String aPropos;

    @Column(name = "phone_number")
    private String numero;

    @Column(name = "add_email")
    private String email;


}
