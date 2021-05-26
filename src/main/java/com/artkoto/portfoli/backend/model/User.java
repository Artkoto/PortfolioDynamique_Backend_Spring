package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.swing.*;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_ame" ,length = (15), unique = true, nullable = false)
    private String user_name;

    @Column(name = "add_email" ,length = (50) , unique = true, nullable = false)
    private String email;


    @Column(name = "password", length = (50), nullable = false )
    private String passwordF;

    @OneToMany( cascade = {CascadeType.ALL})
//    @JoinTable(
//            joinColumns= @JoinColumn(name="user_id", referencedColumnName="id"),
//            inverseJoinColumns= @JoinColumn(name="portfolio_id", referencedColumnName="id"))
    private Set<Personne> portfolios ;
}
