package com.artkoto.portfoli.backend.service;

import com.artkoto.portfoli.backend.model.Personne;
import com.artkoto.portfoli.backend.model.Competence;
import com.artkoto.portfoli.backend.repository.CompetenceRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Data
@Service
public class CompetenceService {

    @Autowired
    private CompetenceRepository competenceRepository;
    @Autowired
    private PersonneService personneService;

    /**
     * recup une competence avec id
     * @param id2
     * @param id
     * @return
     */
    public Optional<Competence> getcompetence(final Long id2,final Long id){
        Optional<Competence> competence = competenceRepository.findById(id);
        Optional<Personne> personne =personneService.getPersonne(id2);
        boolean verification = personne.isPresent()
                && competence.isPresent()
                && personne.stream().iterator().next().getCompetences().contains(competence.stream().iterator().next());
        if (verification){
            return competence;
        }
        return Optional.empty();
    }

    /**
     * obtenir tous les competences
     * @param id
     * @return
     */
    public Iterable<Competence> getcompetences(final Long id){
        Optional<Personne> personne =personneService.getPersonne(id);
        if (personne.isPresent()){
            return personne.stream().iterator().next().getCompetences();
        }
        return new HashSet<>();
    }

    /**
     * delete
     * @param id
     * @param id2
     */
    public void  deletecompetence(final Long id, final Long id2){
        Optional<Competence> competence = competenceRepository.findById(id);
        Optional<Personne> personne =personneService.getPersonne(id2);
        boolean verification = personne.isPresent()
                && competence.isPresent()
                && personne.stream().iterator().next().getCompetences().contains(competence.stream().iterator().next());
        if (verification){
            Personne newPersonne = personne.stream().iterator().next();
            Competence competence1 = competence.stream().iterator().next();
            Set<Competence> competences = new HashSet<>(newPersonne.getCompetences());
            competences.remove(competence1);
            newPersonne.setCompetences(competences);
            personneService.modifyPersonne(id,newPersonne);
            competenceRepository.delete(competence1);
        }

    }

    /**
     * @description  ajout de competence à la liste
     * @param competence
     * @param id
     * @return competence
     */
    public Competence saveCompetence(Competence competence,final Long id ){
        Optional<Personne> personne1 = personneService.getPersonne(id);
        if (personne1.isPresent()){
            Personne personne = personne1.stream().iterator().next();
            Set<Competence> competences = new HashSet<>(personne.getCompetences());
            competences.add(competence);
            personne.setCompetences(competences);
            personneService.modifyPersonne(id,personne);
            return competence;
        }
        return new Competence();
    }

    /**
     * Modification d'un competence existant
     * @param id
     * @param competence
     * @return
     */
    public Competence modifycompetence(final Long id, Competence competence){
        if (competenceRepository.existsById(id)) {
            return competenceRepository.save(competence);
        }
        return new Competence();
    }

}
