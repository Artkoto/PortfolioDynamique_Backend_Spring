package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "experiences")
public class Experience extends Qualification {

    @Column(name = "tools")
    private String outils; //TODO a modifier
}
