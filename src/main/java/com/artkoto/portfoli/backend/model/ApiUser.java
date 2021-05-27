package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ApiUser {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_ame" ,length = (15), unique = true, nullable = false)
    private String user_name;

    @Column(name = "add_email" ,length = (50) , unique = true, nullable = false)
    private String email;

    @Column(name = "password", length = (200), nullable = false )
    private String password;

    @Column(name = "api_key" , length = (200),unique = true, nullable = false )
    private String api_key;

}
