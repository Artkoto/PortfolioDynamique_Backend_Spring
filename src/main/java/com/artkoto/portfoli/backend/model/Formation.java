package com.artkoto.portfoli.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Data
@Entity
@Table(name = "formations")
public class Formation extends Qualification{

}
