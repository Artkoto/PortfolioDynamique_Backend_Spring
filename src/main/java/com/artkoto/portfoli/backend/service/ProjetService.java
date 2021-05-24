package com.artkoto.portfoli.backend.service;

import com.artkoto.portfoli.backend.model.Personne;
import com.artkoto.portfoli.backend.model.Projet;
import com.artkoto.portfoli.backend.repository.ProjetRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Data
@Service
public class ProjetService {
    
    @Autowired
    private ProjetRepository projetRepository;
    @Autowired
    private PersonneService personneService;

    /**
     * recup une projet avec id
     * @param id2
     * @param id
     * @return
     */
    public Optional<Projet> getprojet(final Long id2,final Long id){
        Projet projet = projetRepository.findById(id).stream().iterator().next();
        Personne personne =personneService.getPersonne(id2).stream().iterator().next();
        if (personne != null && personne.getProjets().contains(projet)){
            return projetRepository.findById(id);
        }
        return Optional.empty();
    }

    /**
     * obtenir tous les projets
     * @param id
     * @return
     */
    public Iterable<Projet> getprojets(final Long id){
        Optional<Personne> personne =personneService.getPersonne(id);
        if (personne.isPresent()){
            return personne.stream().iterator().next().getProjets();
        }
        return null;
    }

    /**
     * delete
     * @param id
     * @param id2
     */
    public void  deleteprojet(final Long id, final Long id2){
        Projet projet = projetRepository.findById(id).stream().iterator().next();
        Personne personne =personneService.getPersonne(id2).stream().iterator().next();
        if (personne != null && personne.getProjets().contains(projet)){
            Set<Projet> projets = new HashSet<>(personne.getProjets());
            projets.remove(projet);
            personne.setProjets(projets);
            personneService.modifyPersonne(id,personne);
            projetRepository.delete(projet);
        }

    }

    /**
     * @description  ajout de projet à la liste
     * @param projet
     * @param id
     * @return projet
     */
    public Projet saveProjet(Projet projet,final Long id ){
        if (personneService.getPersonne(id).isPresent()){
            Personne personne = personneService.getPersonne(id).stream().iterator().next();
            Set<Projet> projets = new HashSet<>(personne.getProjets());
            projets.add(projet);
            personne.setProjets(projets);
            personneService.modifyPersonne(id,personne);
            return projet;
        }
        return projet;
    }

    /**
     * Modification d'un projet existant
     * @param id
     * @param projet
     * @return
     */
    public Projet modifyprojet(final Long id, Projet projet){
        if (projetRepository.existsById(id)) {
            // projet projet1 = projetRepository.findById(id).stream().iterator().next();
            return projetRepository.save(projet);
        }
        return null;
    }

}
