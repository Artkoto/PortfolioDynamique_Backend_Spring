package com.artkoto.portfoli.backend.controller;

import com.artkoto.portfoli.backend.model.Projet;
import com.artkoto.portfoli.backend.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProjetController {

    @Autowired
    private ProjetService projetService;

    /**
     * ajout de nouveau projet
     * @param
     * @return
     */
    @PostMapping("/personnes/{id2}/projets/add")
    public Projet saveProjet(Projet projet, @PathVariable("id2") final Long id2){
        return projetService.saveProjet(projet, id2);
    }

    /**
     * update projet
     * @param projet
     * @param id
     * @return
     */
    @PutMapping("/personnes/{id1}/projets/{id}/update")
    public Projet modifProjet(Projet projet, @PathVariable("id") final Long id){
        return projetService.modifyprojet(id,projet);
    }

    /**
     * recup de projet avec id
     * @param id1
     * @param id
     * @return
     */
    @GetMapping("/personnes/{id1}/projets/{id}")
    public Optional<Projet> getProjet(@PathVariable("id1") final Long id1,@PathVariable("id") final Long id){
        return  projetService.getprojet(id1,id);
    }

    /**
     * recup des projets d'une personne
     * @param id1
     * @return
     */
    @GetMapping("/personnes/{id1}/projets")
    public Iterable<Projet> getProjets(@PathVariable("id1") final Long id1){
        return  projetService.getprojets(id1);
    }

    @DeleteMapping("/personnes/{id1}/projets/{id}/delete")
    public void deleProjet (@PathVariable("id1") final Long id1,@PathVariable("id") final Long id){
        projetService.deleteprojet(id,id1);
    }


}
