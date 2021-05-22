package com.artkoto.portfoli.backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "formations")
public class Formation extends Qualification{

}
