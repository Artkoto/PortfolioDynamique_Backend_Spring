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
        Optional<Experience> experience = experienceRepository.findById(id);
        Optional<Personne> personne =personneService.getPersonne(id2);
        boolean verification = personne.isPresent()
                && experience.isPresent()
                && personne.stream().iterator().next().getExperiences().contains(experience.stream().iterator().next());
        if (verification){
            return experience;
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
        return new HashSet<>();
    }

    /**
     * delete
     * @param id
     * @param id2
     */
    public void  deleteexperience(final Long id, final Long id2){
        Optional<Experience> experience = experienceRepository.findById(id);
        Optional<Personne> personne =personneService.getPersonne(id2);
        boolean verification = personne.isPresent()
                && experience.isPresent()
                && personne.stream().iterator().next().getExperiences().contains(experience.stream().iterator().next());
        if (verification){
            Personne newPersonne = personne.stream().iterator().next();
            Experience experience1 = experience.stream().iterator().next();
            Set<Experience> experiences = new HashSet<>(newPersonne.getExperiences());
            experiences.remove(experience1);
            newPersonne.setExperiences(experiences);
            personneService.modifyPersonne(id,newPersonne);
            experienceRepository.delete(experience1);
        }

    }

    /**
     * @description  ajout de experience à la liste
     * @param experience
     * @param id
     * @return experience
     */
    public Experience saveExperience(Experience experience,final Long id ){
        Optional<Personne> personne1 = personneService.getPersonne(id);
        if (personne1.isPresent()){
            Personne personne = personne1.stream().iterator().next();
            Set<Experience> experiences = new HashSet<>(personne.getExperiences());
            experiences.add(experience);
            personne.setExperiences(experiences);
            personneService.modifyPersonne(id,personne);
            return experience;
        }
        return new Experience();
    }

    /**
     * Modification d'un experience existant
     * @param id
     * @param experience
     * @return
     */
    public Experience modifyexperience(final Long id, Experience experience){
        if (experienceRepository.existsById(id)) {
            return experienceRepository.save(experience);
        }
        return new Experience();
    }

}
