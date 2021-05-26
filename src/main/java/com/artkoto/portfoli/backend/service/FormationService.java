package com.artkoto.portfoli.backend.service;

import com.artkoto.portfoli.backend.model.Personne;
import com.artkoto.portfoli.backend.model.Formation;
import com.artkoto.portfoli.backend.repository.FormationRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Data
@Service
public class FormationService {

    @Autowired
    private FormationRepository formationRepository;
    @Autowired
    private PersonneService personneService;

    /**
     * recup une formation avec id
     * @param id2
     * @param id
     * @return
     */
    public Optional<Formation> getformation(final Long id2,final Long id){
        Optional<Formation> formation = formationRepository.findById(id);
        Optional<Personne> personne =personneService.getPersonne(id2);
        boolean verification = personne.isPresent()
                && formation.isPresent()
                && personne.stream().iterator().next().getFormations().contains(formation.stream().iterator().next());
        if (verification){
            return formation;
        }
        return Optional.empty();
    }

    /**
     * obtenir tous les formations
     * @param id
     * @return
     */
    public Iterable<Formation> getformations(final Long id){
        Optional<Personne> personne =personneService.getPersonne(id);
        if (personne.isPresent()){
            return personne.stream().iterator().next().getFormations();
        }
        return new HashSet<>();
    }

    /**
     * delete
     * @param id
     * @param id2
     */
    public void  deleteformation(final Long id, final Long id2){
        Optional<Formation> formation = formationRepository.findById(id);
        Optional<Personne> personne =personneService.getPersonne(id2);
        boolean verification = personne.isPresent()
                && formation.isPresent()
                && personne.stream().iterator().next().getFormations().contains(formation.stream().iterator().next());
        if (verification){
            Personne newPersonne = personne.stream().iterator().next();
            Formation formation1 = formation.stream().iterator().next();
            Set<Formation> formations = new HashSet<>(newPersonne.getFormations());
            formations.remove(formation1);
            newPersonne.setFormations(formations);
            personneService.modifyPersonne(id,newPersonne);
            formationRepository.delete(formation1);
        }

    }

    /**
     * @description  ajout de formation à la liste
     * @param formation
     * @param id
     * @return formation
     */
    public Formation saveFormation(Formation formation,final Long id ){
        Optional<Personne> personne1 = personneService.getPersonne(id);
        if (personne1.isPresent()){
            Personne personne = personne1.stream().iterator().next();
            Set<Formation> formations = new HashSet<>(personne.getFormations());
            formations.add(formation);
            personne.setFormations(formations);
            personneService.modifyPersonne(id,personne);
            return formation;
        }
        return new Formation();
    }

    /**
     * Modification d'un formation existant
     * @param id
     * @param formation
     * @return
     */
    public Formation modifyformation(final Long id, Formation formation){
        if (formationRepository.existsById(id)) {
            return formationRepository.save(formation);
        }
        return new Formation();
    }

}
