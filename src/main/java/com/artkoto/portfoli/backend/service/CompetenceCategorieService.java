package com.artkoto.portfoli.backend.service;


import com.artkoto.portfoli.backend.controller.ProjetController;
import com.artkoto.portfoli.backend.model.CompetenceCategorie;
import com.artkoto.portfoli.backend.repository.CompetenceCategorieRepository;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Data
@Service
public class CompetenceCategorieService {
    @Autowired
    private CompetenceCategorieRepository competenceCategorieRepository;
    @Autowired
    private ProjetController projetController;

    public Iterable<CompetenceCategorie> getCompetenceCategories(){
        return competenceCategorieRepository.findAll();
    }

    public void  deleteCompetenceCategorie(final String id){
        if (competenceCategorieRepository.existsById(id)) {
            competenceCategorieRepository.deleteById(id);
        }
    }

    public CompetenceCategorie saveCompetenceCategorie(CompetenceCategorie competenceCategorie){
        return competenceCategorieRepository.save(competenceCategorie);
    }
    public CompetenceCategorie modifyCompetenceCategorie(final String id, CompetenceCategorie competenceCategorie){
        if (competenceCategorieRepository.existsById(id)) {
            competenceCategorieRepository.deleteById(id);
            return competenceCategorieRepository.save(competenceCategorie);
        }
        return new CompetenceCategorie();
    }

}
