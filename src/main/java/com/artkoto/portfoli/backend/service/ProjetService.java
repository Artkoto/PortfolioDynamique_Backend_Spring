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
        Optional<Projet> projet = projetRepository.findById(id);
        Optional<Personne> personne =personneService.getPersonne(id2);
        boolean verification = personne.isPresent()
                && projet.isPresent()
                && personne.stream().iterator().next().getProjets().contains(projet.stream().iterator().next());
        if (verification){
            return projet;
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
        return new HashSet<>();
    }

    /**
     * delete
     * @param id
     * @param id2
     */
    public void  deleteprojet(final Long id, final Long id2){
        Optional<Projet> projet = projetRepository.findById(id);
        Optional<Personne> personne =personneService.getPersonne(id2);
        boolean verification = personne.isPresent()
                && projet.isPresent()
                && personne.stream().iterator().next().getProjets().contains(projet.stream().iterator().next());
        if (verification){
            Personne newPersonne = personne.stream().iterator().next();
            Projet projet1 = projet.stream().iterator().next();
            Set<Projet> projets = new HashSet<>(newPersonne.getProjets());
            projets.remove(projet1);
            newPersonne.setProjets(projets);
            personneService.modifyPersonne(id,newPersonne);
            projetRepository.delete(projet1);
        }

    }

    /**
     * @description  ajout de projet à la liste
     * @param projet
     * @param id
     * @return projet
     */
    public Projet saveProjet(Projet projet,final Long id ){
        Optional<Personne> personne1 = personneService.getPersonne(id);
        if (personne1.isPresent()){
            Personne personne = personne1.stream().iterator().next();
            Set<Projet> projets = new HashSet<>(personne.getProjets());
            projets.add(projet);
            personne.setProjets(projets);
            personneService.modifyPersonne(id,personne);
            return projet;
        }
        return new Projet();
    }

    /**
     * Modification d'un projet existant
     * @param id
     * @param projet
     * @return
     */
    public Projet modifyprojet(final Long id, Projet projet){
        if (projetRepository.existsById(id)) {
            return projetRepository.save(projet);
        }
        return new Projet();
    }

}
