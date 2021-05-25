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
        Competence competence = competenceRepository.findById(id).stream().iterator().next();
        Personne personne =personneService.getPersonne(id2).stream().iterator().next();
        if (personne != null && personne.getCompetences().contains(competence)){
            return competenceRepository.findById(id);
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
        return null;
    }

    /**
     * delete
     * @param id
     * @param id2
     */
    public void  deletecompetence(final Long id, final Long id2){
        Competence competence = competenceRepository.findById(id).stream().iterator().next();
        Personne personne =personneService.getPersonne(id2).stream().iterator().next();
        if (personne != null && personne.getCompetences().contains(competence)){
            Set<Competence> competences = new HashSet<>(personne.getCompetences());
            competences.remove(competence);
            personne.setCompetences(competences);
            personneService.modifyPersonne(id,personne);
            competenceRepository.delete(competence);
        }

    }

    /**
     * @description  ajout de competence à la liste
     * @param competence
     * @param id
     * @return competence
     */
    public Competence saveCompetence(Competence competence,final Long id ){
        if (personneService.getPersonne(id).isPresent()){
            Personne personne = personneService.getPersonne(id).stream().iterator().next();
            Set<Competence> competences = new HashSet<>(personne.getCompetences());
            competences.add(competence);
            personne.setCompetences(competences);
            personneService.modifyPersonne(id,personne);
            return competence;
        }
        return competence;
    }

    /**
     * Modification d'un competence existant
     * @param id
     * @param competence
     * @return
     */
    public Competence modifycompetence(final Long id, Competence competence){
        if (competenceRepository.existsById(id)) {
            // competence competence1 = competenceRepository.findById(id).stream().iterator().next();
            return competenceRepository.save(competence);
        }
        return null;
    }

}
