package com.artkoto.portfoli.backend.controller;

import com.artkoto.portfoli.backend.model.Personne;
import com.artkoto.portfoli.backend.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonneController {
    @Autowired
    private PersonneService personneService;

    /**
     * @return - Toutes les personnes
     */
    @GetMapping("/personnes")
    public Iterable<Personne> getPersonnes() {
        return personneService.getPersonnes();
    }

    /**
     * @param id
    * @return - la personne avec l'id id
     */
    @GetMapping("/personnes/{id}")
    public Optional<Personne> getPersonne(@PathVariable("id") final Long id){
        return personneService.getPersonne(id);
    }

    /**
     * ajout d'une nouvelle personne
     * @param personne
     * @return la personne cree
     */
    @PostMapping("personnes/add")
    public Personne savePersonne(Personne personne){
        return personneService.savePersonne(personne);
    }

    @PutMapping("personnes/{id}/update")
    public Personne updatePersonne(Personne personne ,@PathVariable("id") final Long id ){
         return personneService.modifyPersonne(id,personne);
    }

    /**
     *
     * @param id
     * suppression d'une personne avec l'id
     */
    @DeleteMapping("/personnes/{id}/delete")
    public void deletePersonne(@PathVariable("id") final Long id){
        personneService.deletePersonne(id);
    }

    }



