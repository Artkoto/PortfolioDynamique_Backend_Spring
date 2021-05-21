package com.artkoto.portfoli.backend.controller;

import com.artkoto.portfoli.backend.model.Personne;
import com.artkoto.portfoli.backend.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonneController {
    @Autowired
    private PersonneService personneService;

    /**
     * Read - Get all personnes
     * @return - An Iterable object of personnes full filled
     */
    @GetMapping("/personnes")
    public Iterable<Personne> getPersonnes() {
        return personneService.getPersonnes();
    }
}

