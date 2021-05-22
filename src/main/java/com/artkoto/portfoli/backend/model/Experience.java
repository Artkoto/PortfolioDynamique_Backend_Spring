package com.artkoto.portfoli.backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "experiences")
public class Experience extends Qualification {

    @Column(name = "tools")
    private String outils;
}
