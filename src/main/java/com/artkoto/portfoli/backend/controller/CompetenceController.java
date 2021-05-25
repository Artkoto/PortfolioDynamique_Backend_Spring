package com.artkoto.portfoli.backend.controller;

import com.artkoto.portfoli.backend.model.Competence;
import com.artkoto.portfoli.backend.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CompetenceController {

    @Autowired
    private CompetenceService competenceService;

    /**
     * ajout de nouveau competence
     * @param
     * @return
     */
    @PostMapping("/personnes/{id2}/competences/add")
    public Competence saveCompetence(Competence competence, @PathVariable("id2") final Long id2){
        return competenceService.saveCompetence(competence, id2);
    }

    /**
     * update competence
     * @param competence
     * @param id
     * @return
     */
    @PutMapping("/personnes/{id1}/competences/{id}/update")
    public Competence modifCompetence(Competence competence, @PathVariable("id") final Long id){
        return competenceService.modifycompetence(id,competence);
    }

    /**
     * recup de competence avec id
     * @param id1
     * @param id
     * @return
     */
    @GetMapping("/personnes/{id1}/competences/{id}")
    public Optional<Competence> getCompetence(@PathVariable("id1") final Long id1,@PathVariable("id") final Long id){
        return  competenceService.getcompetence(id1,id);
    }

    /**
     * recup des competences d'une personne
     * @param id1
     * @return
     */
    @GetMapping("/personnes/{id1}/competences")
    public Iterable<Competence> getCompetences(@PathVariable("id1") final Long id1){
        return  competenceService.getcompetences(id1);
    }

    @DeleteMapping("/personnes/{id1}/competences/{id}/delete")
    public void deleCompetence (@PathVariable("id1") final Long id1,@PathVariable("id") final Long id){
        competenceService.deletecompetence(id,id1);
    }


}
