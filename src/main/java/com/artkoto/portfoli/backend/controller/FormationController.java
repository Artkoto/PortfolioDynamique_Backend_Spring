package com.artkoto.portfoli.backend.controller;

import com.artkoto.portfoli.backend.model.Formation;
import com.artkoto.portfoli.backend.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FormationController {

    @Autowired
    private FormationService formationService;

    /**
     * ajout de nouveau formation
     * @param
     * @return
     */
    @PostMapping("/personnes/{id2}/formations/add")
    public Formation saveFormation(Formation formation, @PathVariable("id2") final Long id2){
        return formationService.saveFormation(formation, id2);
    }

    /**
     * update formation
     * @param formation
     * @param id
     * @return
     */
    @PutMapping("/personnes/{id1}/formations/{id}/update")
    public Formation modifFormation(Formation formation, @PathVariable("id") final Long id){
        return formationService.modifyformation(id,formation);
    }

    /**
     * recup de formation avec id
     * @param id1
     * @param id
     * @return
     */
    @GetMapping("/personnes/{id1}/formations/{id}")
    public Optional<Formation> getFormation(@PathVariable("id1") final Long id1,@PathVariable("id") final Long id){
        return  formationService.getformation(id1,id);
    }

    /**
     * recup des formations d'une personne
     * @param id1
     * @return
     */
    @GetMapping("/personnes/{id1}/formations")
    public Iterable<Formation> getFormations(@PathVariable("id1") final Long id1){
        return  formationService.getformations(id1);
    }

    @DeleteMapping("/personnes/{id1}/formations/{id}/delete")
    public void deleFormation (@PathVariable("id1") final Long id1,@PathVariable("id") final Long id){
        formationService.deleteformation(id,id1);
    }


}
