package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;
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
    private String password;

    @OneToMany ( fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Personne> portfolios ;

}
