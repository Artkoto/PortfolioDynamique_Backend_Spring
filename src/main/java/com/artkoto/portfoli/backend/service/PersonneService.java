package com.artkoto.portfoli.backend.service;


import com.artkoto.portfoli.backend.controller.ProjetController;
import com.artkoto.portfoli.backend.model.Personne;
import com.artkoto.portfoli.backend.repository.PersonneRepository;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Data
@Service
public class PersonneService {
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private ProjetController projetController;

    public Optional<Personne> getPersonne(final Long id){
        return personneRepository.findById(id);
    }

    public Iterable<Personne> getPersonnes(){
        return personneRepository.findAll();
    }

    public void  deletePersonne(final Long id){
        if (personneRepository.existsById(id)) {
            personneRepository.deleteById(id);
        }
    }

    public Personne savePersonne(Personne personne){
        return personneRepository.save(personne);
    }
    public Personne modifyPersonne(final Long id, Personne personne){
        if (personneRepository.existsById(id)) {
           return personneRepository.save(personne);
        }
        return new Personne();
    }

}
