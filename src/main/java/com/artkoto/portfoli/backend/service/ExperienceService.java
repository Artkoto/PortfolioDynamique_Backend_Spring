package com.artkoto.portfoli.backend.service;

import com.artkoto.portfoli.backend.model.Personne;
import com.artkoto.portfoli.backend.model.Experience;
import com.artkoto.portfoli.backend.repository.ExperienceRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Data
@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private PersonneService personneService;

    /**
     * recup une experience avec id
     * @param id2
     * @param id
     * @return
     */
    public Optional<Experience> getexperience(final Long id2,final Long id){
        Experience experience = experienceRepository.findById(id).stream().iterator().next();
        Personne personne =personneService.getPersonne(id2).stream().iterator().next();
        if (personne != null && personne.getExperiences().contains(experience)){
            return experienceRepository.findById(id);
        }
        return Optional.empty();
    }

    /**
     * obtenir tous les experiences
     * @param id
     * @return
     */
    public Iterable<Experience> getexperiences(final Long id){
        Optional<Personne> personne =personneService.getPersonne(id);
        if (personne.isPresent()){
            return personne.stream().iterator().next().getExperiences();
        }
        return null;
    }

    /**
     * delete
     * @param id
     * @param id2
     */
    public void  deleteexperience(final Long id, final Long id2){
        Experience experience = experienceRepository.findById(id).stream().iterator().next();
        Personne personne =personneService.getPersonne(id2).stream().iterator().next();
        if (personne != null && personne.getExperiences().contains(experience)){
            Set<Experience> experiences = new HashSet<>(personne.getExperiences());
            experiences.remove(experience);
            personne.setExperiences(experiences);
            personneService.modifyPersonne(id,personne);
            experienceRepository.delete(experience);
        }

    }

    /**
     * @description  ajout de experience à la liste
     * @param experience
     * @param id
     * @return experience
     */
    public Experience saveExperience(Experience experience,final Long id ){
        if (personneService.getPersonne(id).isPresent()){
            Personne personne = personneService.getPersonne(id).stream().iterator().next();
            Set<Experience> experiences = new HashSet<>(personne.getExperiences());
            experiences.add(experience);
            personne.setExperiences(experiences);
            personneService.modifyPersonne(id,personne);
            return experience;
        }
        return experience;
    }

    /**
     * Modification d'un experience existant
     * @param id
     * @param experience
     * @return
     */
    public Experience modifyexperience(final Long id, Experience experience){
        if (experienceRepository.existsById(id)) {
            // experience experience1 = experienceRepository.findById(id).stream().iterator().next();
            return experienceRepository.save(experience);
        }
        return null;
    }

}
