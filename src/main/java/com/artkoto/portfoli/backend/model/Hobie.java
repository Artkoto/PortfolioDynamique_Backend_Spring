package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "hobies")
public class Hobie {
    @Id
    private String name;

//    @ManyToMany
//    Set<Personne> personnes;
}
