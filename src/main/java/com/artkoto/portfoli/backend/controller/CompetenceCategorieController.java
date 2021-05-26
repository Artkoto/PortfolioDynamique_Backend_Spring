package com.artkoto.portfoli.backend.controller;

import com.artkoto.portfoli.backend.model.CompetenceCategorie;
import com.artkoto.portfoli.backend.service.CompetenceCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CompetenceCategorieController {
    @Autowired
    private CompetenceCategorieService competenceCategorieService;

    /**
     * @return - Toutes les competenceCategories
     */
    @GetMapping("/competence_categories")
    public Iterable<CompetenceCategorie> getCompetenceCategories() {
        return competenceCategorieService.getCompetenceCategories();
    }


    /**
     * ajout d'une nouvelle competenceCategorie
     * @param competenceCategorie
     * @return la competenceCategorie cree
     */
    @PostMapping("competence_categories/add")
    public CompetenceCategorie saveCompetenceCategorie(CompetenceCategorie competenceCategorie){
        return competenceCategorieService.saveCompetenceCategorie(competenceCategorie);
    }

    @PutMapping("competence_categories/{id}/update")
    public CompetenceCategorie updateCompetenceCategorie(CompetenceCategorie competenceCategorie ,@PathVariable("id") final String id ){
        return competenceCategorieService.modifyCompetenceCategorie(id,competenceCategorie);
    }

    /**
     *
     * @param id
     * suppression d'une competenceCategorie avec l'id
     */
    @DeleteMapping("/competence_categories/{id}/delete")
    public void deleteCompetenceCategorie(@PathVariable("id") final String id){
        competenceCategorieService.deleteCompetenceCategorie(id);
    }
    //TODO ajot des autres requettes

}



