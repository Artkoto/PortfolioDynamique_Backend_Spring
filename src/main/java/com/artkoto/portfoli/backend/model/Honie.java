package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hobies")
public class Honie {
    @Id
    private String name;
}
