package com.artkoto.portfoli.backend.service;


import com.artkoto.portfoli.backend.model.Personne;
import com.artkoto.portfoli.backend.repository.PresonneRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class PersonneService {
    @Autowired
    private PresonneRepository  personneRepository;

    public Optional<Personne> getPersonne(final Long id){
        return personneRepository.findById(id);
    }

    public Iterable<Personne> getPersonnes(){
        return personneRepository.findAll();
    }

    public void  deletePersonne(final Long id){
        personneRepository.deleteById(id);
    }

    public Personne savePersonne(Personne personne){
        Personne personneSauve = personneRepository.save(personne);
        return personneSauve;
    }
}
