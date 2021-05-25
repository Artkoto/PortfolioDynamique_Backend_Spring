package com.artkoto.portfoli.backend.controller;

import com.artkoto.portfoli.backend.model.Experience;
import com.artkoto.portfoli.backend.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    /**
     * ajout de nouveau experience
     * @param
     * @return
     */
    @PostMapping("/personnes/{id2}/experiences/add")
    public Experience saveExperience(Experience experience, @PathVariable("id2") final Long id2){
        return experienceService.saveExperience(experience, id2);
    }

    /**
     * update experience
     * @param experience
     * @param id
     * @return
     */
    @PutMapping("/personnes/{id1}/experiences/{id}/update")
    public Experience modifExperience(Experience experience, @PathVariable("id") final Long id){
        return experienceService.modifyexperience(id,experience);
    }

    /**
     * recup de experience avec id
     * @param id1
     * @param id
     * @return
     */
    @GetMapping("/personnes/{id1}/experiences/{id}")
    public Optional<Experience> getExperience(@PathVariable("id1") final Long id1,@PathVariable("id") final Long id){
        return  experienceService.getexperience(id1,id);
    }

    /**
     * recup des experiences d'une personne
     * @param id1
     * @return
     */
    @GetMapping("/personnes/{id1}/experiences")
    public Iterable<Experience> getExperiences(@PathVariable("id1") final Long id1){
        return  experienceService.getexperiences(id1);
    }

    @DeleteMapping("/personnes/{id1}/experiences/{id}/delete")
    public void deleExperience (@PathVariable("id1") final Long id1,@PathVariable("id") final Long id){
        experienceService.deleteexperience(id,id1);
    }


}
