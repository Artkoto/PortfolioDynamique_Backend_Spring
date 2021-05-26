package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CompetenceCategorie {
    @Id
    private String name;

}
